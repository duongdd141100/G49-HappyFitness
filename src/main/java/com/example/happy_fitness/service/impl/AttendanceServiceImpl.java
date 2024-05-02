package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Attendance;
import com.example.happy_fitness.repository.AttendanceRepository;
import com.example.happy_fitness.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepo;

    @Override
    public List<Attendance> findAllByScheduleId(Long scheduleId) {
        return attendanceRepo.findAllByTrainHistory_Id(scheduleId)
                .stream().map(x -> {
                    x.getClassStudent().setClazz(null);
                    x.setTrainHistory(null);
                    return x;
                }).toList();
    }

    @Override
    public String updateAttendance(List<Attendance> attendances) {
        List<Attendance> originAttendances = attendanceRepo.findAllById(attendances
                .stream().map(Attendance::getId).toList());
        if (attendances.stream().anyMatch(x -> x.getStatus().equals("ATTENDED"))) {
            originAttendances.getFirst().getTrainHistory().setStatus("ATTENDED");
        } else {
            originAttendances.getFirst().getTrainHistory().setStatus("ABSENT");
        }
        attendanceRepo.saveAll(originAttendances.stream().map(x -> {
            Attendance updateAttendance = attendances
                    .stream().filter(attendance -> attendance.getId().equals(x.getId())).findFirst().get();
            if (x.getStatus().equals("NOT_YET")) {
                if (updateAttendance.getStatus().equals("ATTENDED")) {
                    x.getClassStudent().setRemainSlot(x.getClassStudent().getRemainSlot() - 1);
                }
            } else {
                if (!updateAttendance.getStatus().equals(x.getStatus())) {
                    if (updateAttendance.getStatus().equals("ATTENDED")) {
                        x.getClassStudent().setRemainSlot(x.getClassStudent().getRemainSlot() - 1);
                    } else {
                        x.getClassStudent().setRemainSlot(x.getClassStudent().getRemainSlot() + 1);
                    }
                }
            }
            x.setStatus(updateAttendance.getStatus());
            return x;
        }).toList());
        return HttpStatus.OK.getReasonPhrase();
    }
}
