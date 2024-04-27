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

import java.util.List;
import java.util.Random;

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
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }
}
