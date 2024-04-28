package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.Schedule;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.ScheduleRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepo;

    @Autowired
    private UserRepository userRepo;

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
    public List<Schedule> findAll(UserDetails userDetails) {
        List<Schedule> schedules = null;
        String requesterRole = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        if (RoleEnum.ROLE_ADMIN.name().equals(requesterRole)) {
            schedules = scheduleRepo.findAll();
        }
        if (Arrays.asList(RoleEnum.ROLE_MANAGER.name(), RoleEnum.ROLE_RECEPTIONIST.name()).contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            schedules = scheduleRepo.findAllByFacility(requester.getFacility());
        }
        if (RoleEnum.ROLE_CUSTOMER.name().contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            schedules = scheduleRepo.findAllByCustomer(requester);
        }
        if (RoleEnum.ROLE_PERSONAL_TRAINER.name().contains(requesterRole)) {
            User requester = userRepo.findByUsername(userDetails.getUsername());
            schedules = scheduleRepo.findAllByPt(requester);
        }
        return schedules.stream().map(x -> {
            x.getPt().setFacility(null);
            x.getFacility().setManager(null);
            return x;
        }).toList();
    }
}
