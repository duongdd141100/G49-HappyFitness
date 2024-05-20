package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Clazz;
import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.entity.TrainHistory;
import com.example.happy_fitness.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainHistoryRepository extends JpaRepository<TrainHistory, Long> {
    List<TrainHistory> findAllByClazz_Pt_Facility(Facility facility);

    List<TrainHistory> findAllByClazzIn(List<Clazz> clazzes);

    List<TrainHistory> findAllByClazz_Pt(User pt);

    Boolean existsByClazzInAndTrainDateAndTrainTime_Id(List<Clazz> clazzes, LocalDate trainDate, Long trainTimeId);

    Boolean existsByClazz_PtAndTrainDateAndTrainTime_Id(User pt, LocalDate trainDate, Long trainTimeId);

    List<TrainHistory> findAllByPt(User pt);

    List<TrainHistory> findAllByClazzAndTrainDateGreaterThanEqual(Clazz clazz, LocalDate date);
}
