package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.OrderStatusEnum;
import com.example.happy_fitness.dto.BookingRequestBodyDto;
import com.example.happy_fitness.entity.*;
import com.example.happy_fitness.entity.Package;
import com.example.happy_fitness.repository.*;
import com.example.happy_fitness.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CustomerTicketRepository customerTicketRepo;

    @Autowired
    private ClassRepository classRepo;

    @Autowired
    private PackageRepository packageRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TrainTimeRepository trainTimeRepo;

    @Autowired
    private TrainScheduleRepository trainScheduleRepo;

    @Autowired
    private TrainHistoryRepository trainHistoryRepo;

    @Autowired
    private ClassStudentRepository classStudentRepo;

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Autowired
    private TrainFeeRepository trainFeeRepo;

    @Override
    public String updateOrderInfo(String code, Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.ORDER_NOT_EXIST.getCode()));
        if ("00".equals(code)) {
            order.setPaid(true);
        } else if ("24".equals(code)) {
            order.setStatus(OrderStatusEnum.CANCELLED.name());
        }
        orderRepo.save(order);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String updateTicketInfo(String responseCode, Long ticketId) {
        CustomerTicket customerTicket = customerTicketRepo.findById(ticketId)
                .orElseThrow(() -> new RuntimeException(ErrorMessageEnum.ORDER_NOT_EXIST.getCode()));
        if ("00".equals(responseCode)) {
            customerTicket.setPaid(true);
            customerTicket.setStatus(true);
        }
        customerTicketRepo.save(customerTicket);
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createSchedule(String responseCode, BookingRequestBodyDto bookingRequestBodyDto, UserDetails userDetails) {
        if ("00".equals(responseCode)) {
            Package aPackage = packageRepo.findById(bookingRequestBodyDto.getPackageId()).get();
            User student = userRepo.findByUsername(userDetails.getUsername());
            Clazz clazz = new Clazz();
            clazz.setName("Lớp 1-1 " + student.getFullName());
            clazz.setAPackage(aPackage);
            clazz.setStatus("ACTIVE");
            clazz.setType(aPackage.getType());
            clazz.setPt(userRepo.findById(bookingRequestBodyDto.getPtId()).get());
            clazz = classRepo.save(clazz);
            ClassStudent classStudent = new ClassStudent();
            classStudent.setClazz(clazz);
            classStudent.setStudent(student);
            classStudent.setRemainSlot(aPackage.getTotalSlot());
            classStudent = classStudentRepo.save(classStudent);
            List<TrainSchedule> trainSchedules = new ArrayList<>();
            Clazz finalClazz = clazz;
            for (Map.Entry<Integer, Long> entry : bookingRequestBodyDto.getMapDayOfWeekWithTrainTimeId().entrySet()) {
                TrainSchedule trainSchedule = new TrainSchedule();
                trainSchedule.setTrainTime(trainTimeRepo.findById(entry.getValue()).get());
                trainSchedule.setDayOfWeek(entry.getKey());
                trainSchedule.setClazz(finalClazz);
                trainSchedules.add(trainSchedule);
            }
            trainScheduleRepo.saveAll(trainSchedules);
            List<TrainHistory> trainHistories = new ArrayList<>();
            while (trainHistories.size() < aPackage.getTotalSlot()) {
                Integer size = trainHistories.size();
                LocalDate localDate = size > 0
                        ? trainHistories.get(size - 1).getTrainDate().plusDays(1)
                        : LocalDate.now().plusDays(1);
                while (trainHistories.size() == size) {
                    Integer dayOfWeek = localDate.getDayOfWeek().getValue() + 1;
                    if (bookingRequestBodyDto.getMapDayOfWeekWithTrainTimeId().containsKey((dayOfWeek))) {
                        TrainHistory trainHistory = new TrainHistory();
                        trainHistory.setClazz(clazz);
                        trainHistory.setTrainDate(localDate);
                        trainHistory.setStatus("NOT_YET");
                        trainHistory.setDayOfWeek(dayOfWeek);
                        TrainTime trainTime = new TrainTime();
                        trainTime.setId(bookingRequestBodyDto.getMapDayOfWeekWithTrainTimeId().get(dayOfWeek));
                        trainHistory.setTrainTime(trainTime);
                        trainHistories.add(trainHistory);
                    } else {
                        localDate = localDate.plusDays(1);
                    }
                }
            }
            trainHistories = trainHistoryRepo.saveAll(trainHistories);
            List<Attendance> attendances = new ArrayList<>();
            ClassStudent finalClassStudent = classStudent;
            trainHistories.forEach(x -> {
                Attendance attendance = new Attendance();
                attendance.setClassStudent(finalClassStudent);
                attendance.setTrainHistory(x);
                attendance.setStatus("NOT_YET");
                attendances.add(attendance);
            });
            attendanceRepo.saveAll(attendances);
            TrainFee trainFee = new TrainFee();
            trainFee.setClazz(clazz);
            trainFee.setPrice(aPackage.getPrice());
            trainFee.setStudent(student);
            trainFee.setIsPaid(true);
            trainFeeRepo.save(trainFee);
        }
        return HttpStatus.OK.getReasonPhrase();
    }

    @Override
    public String joinClass(BookingRequestBodyDto bookingRequestBodyDto, UserDetails userDetails, String responseCode) {
        if ("00".equals(responseCode)) {
            User student = userRepo.findByUsername(userDetails.getUsername());
            Clazz clazz = classRepo.findById(bookingRequestBodyDto.getClassId()).get();
            Package aPackage = packageRepo.findById(bookingRequestBodyDto.getPackageId()).get();
            ClassStudent classStudent = new ClassStudent();
            classStudent.setClazz(clazz);
            classStudent.setStudent(student);
            classStudent.setRemainSlot(aPackage.getTotalSlot());
            classStudent.setAPackage(new Package());
            classStudent.getAPackage().setId(bookingRequestBodyDto.getPackageId());
            classStudentRepo.save(classStudent);
            TrainFee trainFee = new TrainFee();
            trainFee.setIsPaid(true);
            trainFee.setStudent(student);
            trainFee.setClazz(clazz);
            trainFee.setPrice(aPackage.getPrice());
            trainFeeRepo.save(trainFee);
        }
        return HttpStatus.OK.getReasonPhrase();
    }
}
