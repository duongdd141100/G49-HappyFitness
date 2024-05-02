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
            Clazz clazz = new Clazz();
            clazz.setAPackage(aPackage);
            clazz.setStatus("ACTIVE");
            clazz.setPt(userRepo.findById(bookingRequestBodyDto.getPtId()).get());
            clazz = classRepo.save(clazz);
            ClassStudent classStudent = new ClassStudent();
            classStudent.setClazz(clazz);
            classStudent.setStudent(userRepo.findByUsername(userDetails.getUsername()));
            classStudent.setRemainSlot(aPackage.getTotalSlot());
            classStudent = classStudentRepo.save(classStudent);
            List<TrainSchedule> trainSchedules = new ArrayList<>();
            Clazz finalClazz = clazz;
            bookingRequestBodyDto.getDayOfWeeks().forEach(x -> {
                TrainSchedule trainSchedule = new TrainSchedule();
                trainSchedule.setTrainTime(trainTimeRepo.findById(bookingRequestBodyDto.getTrainTimeId()).get());
                trainSchedule.setDayOfWeek(x);
                trainSchedule.setClazz(finalClazz);
                trainSchedules.add(trainSchedule);
            });
            trainScheduleRepo.saveAll(trainSchedules);
            List<TrainHistory> trainHistories = new ArrayList<>();
            while (trainHistories.size() < aPackage.getTotalSlot()) {
                Integer size = trainHistories.size();
                LocalDate localDate = size > 0
                        ? trainHistories.get(size - 1).getTrainDate().plusDays(1)
                        : LocalDate.now().plusDays(1);
                while (trainHistories.size() == size) {
                    if (bookingRequestBodyDto.getDayOfWeeks().contains(localDate.getDayOfWeek().getValue() + 1)) {
                        TrainHistory trainHistory = new TrainHistory();
                        trainHistory.setClazz(clazz);
                        trainHistory.setTrainDate(localDate);
                        trainHistory.setStatus("NOT_YET");
                        trainHistory.setDayOfWeek(localDate.getDayOfWeek().getValue() + 1);
                        trainHistory.setTrainTime(trainSchedules.getFirst().getTrainTime());
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
        }
        return HttpStatus.OK.getReasonPhrase();
    }
}
