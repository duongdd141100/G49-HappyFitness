package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainScheduleRepository extends JpaRepository<TrainSchedule, Long> {
    List<TrainSchedule> findAllByTrainTime_IdAndClazz_Pt_Facility_IdAndDayOfWeekIn(Long trainTimeId, Long facilityId, List<Integer> dayOfWeeks);
}
