package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Schedule;
import com.example.happy_fitness.entity.TrainHistory;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ScheduleService extends BaseService<TrainHistory> {
    List<TrainHistory> findAll(UserDetails userDetails);

    String attend(Long scheduleId, UserDetails userDetails);
}
