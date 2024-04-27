package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.TrainTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainTimeRepository extends JpaRepository<TrainTime, Long> {
}
