package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> findAllByScheduleId(Long scheduleId);

    String updateAttendance(List<Attendance> attendances);
}
