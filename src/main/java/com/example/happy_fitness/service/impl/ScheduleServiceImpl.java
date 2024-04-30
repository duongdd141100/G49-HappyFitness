package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.*;
import com.example.happy_fitness.repository.*;
import com.example.happy_fitness.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

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

    @Override
    public String create(UserDetails userDetails, Schedule schedule) {
        if (scheduleRepo.findByCustomer_UsernameAndTrainDateAndTrainTime_Id(userDetails.getUsername(), schedule.getTrainDate(), schedule.getTrainTime().getId())
                .isPresent()) {
            throw new RuntimeException(ErrorMessageEnum.SCHEDULE_EXIST.getCode());
        }
        List<User> busyPt = scheduleRepo.findByTrainDateAndTrainTime_IdAndFacility_Id(schedule.getTrainDate(), schedule.getTrainTime().getId(), schedule.getFacility().getId())
                .stream().map(Schedule::getPt).toList();
        List<User> availablePt = userRepo.findAllByRole_IdAndFacility_Id(RoleEnum.ROLE_PERSONAL_TRAINER.getId(), schedule.getFacility().getId())
                .stream().filter(x -> !busyPt.contains(x)).toList();
        if (availablePt.isEmpty()) {
            throw new RuntimeException(ErrorMessageEnum.PT_BUSY.getCode());
        }
        if (schedule.getTrainDate().equals(LocalDate.now())) {
            TrainTime trainTime = trainTimeRepo.findById(schedule.getTrainTime().getId()).get();
            if (trainTime.getStartTime().isBefore(LocalTime.now())) {
                throw new RuntimeException(ErrorMessageEnum.TRAIN_TIME_INVALID.getCode());
            }
        }
        Random random = new Random();
        schedule.setPt(availablePt.get(random.nextInt(availablePt.size())));
        schedule.setCustomer(userRepo.findByUsername(userDetails.getUsername()));
        scheduleRepo.save(schedule);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String update(Schedule schedule, Long id, UserDetails userDetails) {
        Optional<Schedule> existSchedule = scheduleRepo.findByCustomer_UsernameAndTrainDateAndTrainTime_Id(userDetails.getUsername(), schedule.getTrainDate(), schedule.getTrainTime().getId());
        if (existSchedule.isPresent() && !existSchedule.get().getId().equals(schedule.getId())) {
            throw new RuntimeException(ErrorMessageEnum.SCHEDULE_EXIST.getCode());
        }
        Schedule originSchedule = scheduleRepo.findById(id).get();
        if (originSchedule.getFacility().getId().equals(schedule.getFacility().getId())
            && originSchedule.getTrainDate().equals(schedule.getTrainDate())
            && originSchedule.getTrainTime().getId().equals(schedule.getTrainTime().getId())) {
            return HttpStatus.OK.getReasonPhrase();
        } else {
            List<User> busyPt = scheduleRepo.findByTrainDateAndTrainTime_IdAndFacility_Id(schedule.getTrainDate(), schedule.getTrainTime().getId(), schedule.getFacility().getId())
                    .stream().map(Schedule::getPt).toList();
            List<User> availablePt = userRepo.findAllByRole_IdAndFacility_Id(RoleEnum.ROLE_PERSONAL_TRAINER.getId(), schedule.getFacility().getId())
                    .stream().filter(x -> !busyPt.contains(x)).toList();
            if (availablePt.isEmpty()) {
                throw new RuntimeException(ErrorMessageEnum.PT_BUSY.getCode());
            }
            if (schedule.getTrainDate().equals(LocalDate.now())) {
                TrainTime trainTime = trainTimeRepo.findById(schedule.getTrainTime().getId()).get();
                if (trainTime.getStartTime().isBefore(LocalTime.now())) {
                    throw new RuntimeException(ErrorMessageEnum.TRAIN_TIME_INVALID.getCode());
                }
            }
            Random random = new Random();
            originSchedule.getFacility().setId(schedule.getId());
            originSchedule.setTrainDate(schedule.getTrainDate());
            originSchedule.getTrainTime().setId(schedule.getTrainTime().getId());
            originSchedule.setPt(availablePt.get(random.nextInt(availablePt.size())));
            originSchedule.setCustomer(userRepo.findByUsername(userDetails.getUsername()));
            scheduleRepo.save(originSchedule);
            return HttpStatus.OK.getReasonPhrase();
        }
    }

    @Override
    public void delete(List<Long> ids) {
        Schedule schedule = scheduleRepo.findById(ids.get(0)).get();
        schedule.setStatus(false);
        scheduleRepo.save(schedule);
    }

    @Override
    public List<TrainHistory> findAll(UserDetails userDetails) {
        List<TrainHistory> schedules = null;
        String requesterRole = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        if (RoleEnum.ROLE_ADMIN.name().equals(requesterRole)) {
            schedules = trainHistoryRepo.findAll();
        }
        if (Arrays.asList(RoleEnum.ROLE_MANAGER.name(), RoleEnum.ROLE_RECEPTIONIST.name()).contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            schedules = trainHistoryRepo.findAllByClazz_Pt_Facility(requester.getFacility());
        }
        if (RoleEnum.ROLE_CUSTOMER.name().contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            List<ClassStudent> clazzes = classStudentRepo.findAllByStudent(requester);
            schedules = trainHistoryRepo.findAllByClazzIn(clazzes.stream().map(ClassStudent::getClazz).toList());
        }
        if (RoleEnum.ROLE_PERSONAL_TRAINER.name().contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            schedules = trainHistoryRepo.findAllByClazz_Pt(requester);
        }
        return schedules.stream().map(x -> {
            x.getClazz().getPt().setFacility(null);
            return x;
        }).toList();
    }
}
