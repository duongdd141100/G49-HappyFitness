package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.TrainTime;
import com.example.happy_fitness.repository.TrainTimeRepository;
import com.example.happy_fitness.service.TrainTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTimeServiceImpl implements TrainTimeService {
    @Autowired
    private TrainTimeRepository trainTimeRepo;

    @Override
    public List<TrainTime> findAll() {
        return trainTimeRepo.findAll();
    }
}
