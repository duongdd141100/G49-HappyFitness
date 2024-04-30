package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.TrainHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainHistoryRepository extends JpaRepository<TrainHistory, Long> {
}
