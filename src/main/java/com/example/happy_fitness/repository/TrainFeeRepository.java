package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.TrainFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainFeeRepository extends JpaRepository<TrainFee, Long> {
}
