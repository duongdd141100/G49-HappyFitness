package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Optional<Schedule> findByCustomer_UsernameAndTrainDateAndTrainTime_Id(String customerUsername, LocalDate trainDate, Long trainTimeId);

    List<Schedule> findByTrainDateAndTrainTime_IdAndFacility_Id(LocalDate trainDate, Long trainTimeId, Long facilityId);
}
