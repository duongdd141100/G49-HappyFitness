package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Attendance findByClassStudent_IdAndTrainHistory_Id(Long classStudentId, Long trainHistoryId);

    List<Attendance> findAllByTrainHistory_Id(Long scheduleId);
}
