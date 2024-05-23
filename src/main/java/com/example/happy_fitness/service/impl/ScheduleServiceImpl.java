package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.*;
import com.example.happy_fitness.repository.*;
import com.example.happy_fitness.service.EmailService;
import com.example.happy_fitness.service.ScheduleService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TrainTimeRepository trainTimeRepo;

    @Autowired
    private TrainHistoryRepository trainHistoryRepo;

    @Autowired
    private ClassStudentRepository classStudentRepo;

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Autowired
    private EmailService emailService;

    @Autowired
    private MailTemplateRepository mailTemplateRepo;

    @Override
    public String create(UserDetails userDetails, TrainHistory trainHistory) {
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String update(TrainHistory trainHistory, Long id, UserDetails userDetails) throws MessagingException {
        if (trainHistory.getTrainDate() != null && trainHistory.getTrainDate().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            throw new RuntimeException("Xin lỗi! Chủ nhật trung tâm đóng cửa!");
        }
        TrainHistory originSchedule = trainHistoryRepo.findById(id).get();
        if ((trainHistory.getTrainTime() != null
                && trainHistory.getTrainDate()!= null)
                && (!originSchedule.getTrainTime().getId().equals(trainHistory.getTrainTime().getId())
                || !originSchedule.getTrainDate().isEqual(trainHistory.getTrainDate()))) {
            LocalDateTime now = LocalDateTime.now();
            TrainTime trainTimeUpdate = trainTimeRepo.findById(trainHistory.getTrainTime().getId()).get();
            if (trainHistory.getTrainDate().isBefore(now.toLocalDate())
            || (trainHistory.getTrainDate().isEqual(now.toLocalDate())
                    && trainTimeUpdate.getStartTime().isBefore(now.toLocalTime()))) {
                throw new RuntimeException(ErrorMessageEnum.TRAIN_TIME_INVALID.getCode());
            }
            if (trainHistoryRepo.existsByClazzInAndTrainDateAndTrainTime_Id
                    (Arrays.asList(originSchedule.getClazz()), trainHistory.getTrainDate(), trainHistory.getTrainTime().getId())) {
                throw new RuntimeException(ErrorMessageEnum.SCHEDULE_EXIST.getCode());
            }
            if (trainHistoryRepo.existsByClazz_PtAndTrainDateAndTrainTime_Id
                    (originSchedule.getClazz().getPt(), trainHistory.getTrainDate(), trainHistory.getTrainTime().getId())) {
                throw new RuntimeException(ErrorMessageEnum.YOUR_PT_BUSY.getCode());
            }
            String oldTrainDate = originSchedule.getTrainDate().toString();
            TrainTime oldTrainTime = originSchedule.getTrainTime();
            originSchedule.setTrainDate(trainHistory.getTrainDate());
            originSchedule.setTrainTime(trainTimeUpdate);
            originSchedule.setDayOfWeek(trainHistory.getTrainDate().getDayOfWeek().getValue() + 1);
            List<User> receptionists = userRepo.findAllByRole_IdAndFacility_Id(4L, originSchedule.getPt().getFacility().getId());
            receptionists.stream().map(User::getEmail).toArray();
            MailTemplate template = mailTemplateRepo.findByCode("NOTIFY_UPDATE_TRAIN_DATETIME");
            List<String> to = new ArrayList<>(receptionists.stream().map(User::getEmail).toList());
            to.add(originSchedule.getPt().getEmail());
            String[] toArr = new String[to.size()];
            toArr = to.toArray(toArr);
            emailService.send(toArr,
                    template.getSubject(),
                    String.format(template.getContent(),
                            originSchedule.getClazz().getName(),
                            originSchedule.getPt().getFullName(),
                            oldTrainDate + " (" + oldTrainTime.getStartTime().toString() + " - " + oldTrainTime.getEndTime().toString() + ")",
                            trainHistory.getTrainDate().toString()
                                    + " (" +
                                    trainTimeUpdate.getStartTime().toString() + " - " + trainTimeUpdate.getEndTime().toString() + ")",
                    new MultipartFile[]{}));
            trainHistoryRepo.save(originSchedule);
        }
        if (trainHistory.getPt() != null
                && !originSchedule.getPt().getId().equals(trainHistory.getPt().getId())) {
            originSchedule.setPt(userRepo.findById(trainHistory.getPt().getId()).get());
            trainHistoryRepo.save(originSchedule);
        }
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public void delete(List<Long> ids) {
        Schedule schedule = scheduleRepo.findById(ids.get(0)).get();
        schedule.setStatus(false);
        scheduleRepo.save(schedule);
    }

    @Override
    public List<TrainHistory> findAll(UserDetails userDetails, Long classId) {
        List<TrainHistory> schedules = null;
        String requesterRole = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        User requester = userRepo.findByUsername(userDetails.getUsername());
        if (RoleEnum.ROLE_ADMIN.name().equals(requesterRole)) {
            schedules = trainHistoryRepo.findAll();
        }
        if (Arrays.asList(RoleEnum.ROLE_MANAGER.name(), RoleEnum.ROLE_RECEPTIONIST.name()).contains(requesterRole)) {
            schedules = trainHistoryRepo.findAllByClazz_Pt_Facility(requester.getFacility());
        }
        if (RoleEnum.ROLE_CUSTOMER.name().contains(requesterRole)) {
            List<ClassStudent> clazzes = classStudentRepo.findAllByStudent(requester);
            List<Attendance> attendances = attendanceRepo.findAllByClassStudentIn(clazzes);
            List<Long> validScheduleIds = attendances.stream().map(x -> x.getTrainHistory().getId()).toList();
            schedules = trainHistoryRepo.findAllByClazzIn(clazzes.stream().map(ClassStudent::getClazz).toList())
                    .stream().filter(x -> validScheduleIds.contains(x.getId())).toList();
        }
        if (RoleEnum.ROLE_PERSONAL_TRAINER.name().contains(requesterRole)) {
            schedules = trainHistoryRepo.findAllByPt(requester);
        }
        if (classId != null) {
            schedules = schedules.stream().filter(x -> x.getClazz().getId().equals(classId)).toList();
        }
        // TODO: fix this
//        schedules.sort(Comparator.comparing(TrainHistory::getTrainDate));
        return schedules.stream().map(x -> {
            x.getClazz().getPt().getFacility().setManager(null);
            x.getClazz().setTrainSchedules(null);
            x.getClazz().getClassStudents()
                    .forEach(classStudent -> classStudent.setClazz(null));
            x.setAttendances(x.getAttendances().stream().map(attendance -> {
                attendance.setTrainHistory(null);
                attendance.getClassStudent().setClazz(null);
                return attendance;
            }).toList());
            x.getPt().getFacility().setManager(null);
            return x;
        }).toList();
    }

    @Override
    public String attend(Long scheduleId, UserDetails userDetails, Long studentId) {
        TrainHistory trainHistory = trainHistoryRepo.findById(scheduleId).get();
        if (!LocalDate.now().isEqual(trainHistory.getTrainDate())) {
            throw new RuntimeException(ErrorMessageEnum.ATTEND_FAILED_INVALID_DATE.getCode());
        }
        trainHistory.setStatus("ATTENDED");
        ClassStudent classStudent = new ClassStudent();
        for (ClassStudent x : trainHistory.getClazz().getClassStudents()) {
            if (x.getStudent().getId().equals(studentId)) {
                classStudent = x;
                x.setRemainSlot(x.getRemainSlot() - 1);
                break;
            }
        }
//        Attendance attendance = attendanceRepo.findByClassStudent_IdAndTrainHistory_Id(trainHistory.getClazz().getClassStudents()
//                .stream()
//                .filter(x -> x.getStudent().getId().equals(studentId))
//                .findFirst().get().getId(), trainHistory.getId());
        Attendance attendance = attendanceRepo.findByClassStudent_IdAndTrainHistory_Id(classStudent.getId(), trainHistory.getId());
        attendance.setStatus("ATTENDED");
        attendanceRepo.save(attendance);
        trainHistoryRepo.save(trainHistory);
        return HttpStatus.OK.getReasonPhrase();
    }
}
