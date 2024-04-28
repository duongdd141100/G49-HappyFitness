package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Schedule;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ScheduleService extends BaseService<Schedule> {
    List<Schedule> findAll(UserDetails userDetails);
}
