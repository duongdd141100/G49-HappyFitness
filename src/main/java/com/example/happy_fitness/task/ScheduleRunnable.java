package com.example.happy_fitness.task;

import com.example.happy_fitness.entity.Attendance;
import com.example.happy_fitness.entity.Clazz;
import com.example.happy_fitness.entity.TrainHistory;
import com.example.happy_fitness.repository.AttendanceRepository;
import com.example.happy_fitness.repository.ClassRepository;
import com.example.happy_fitness.repository.TrainHistoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class ScheduleRunnable {
    @Autowired
    private ClassRepository classRepo;

    @Autowired
    private TrainHistoryRepository trainHistoryRepo;

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Transactional(rollbackFor = Exception.class)
    public void createScheduleNextWeek() {
        List<Clazz> clazzes = classRepo.findAllByStatusAndType("ACTIVE", "ONE_ON_MANY")
                .stream().filter(x -> !CollectionUtils.isEmpty(x.getClassStudents())
                        && x.getClassStudents()
                        .stream().anyMatch(classStudent -> classStudent.getRemainSlot() > 0)).toList();
        List<TrainHistory> trainHistories = new ArrayList<>();
        List<Attendance> attendances = new ArrayList<>();
        for (Clazz clazz : clazzes) {
            LocalDate localDate = LocalDate.now().plusDays(2);
            while (localDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                TrainHistory trainHistory = new TrainHistory();
                trainHistory.setStatus("NOT_YET");
                trainHistory.setTrainTime(clazz.getTrainSchedules().getFirst().getTrainTime());
                trainHistory.setTrainDate(localDate);
                trainHistory.setDayOfWeek(localDate.getDayOfWeek().getValue() + 1);
                trainHistory.setClazz(clazz);
                trainHistories.add(trainHistory);
                clazz.getClassStudents().forEach(x -> {
                    if (attendances.stream()
                            .filter(attendance -> attendance.getClassStudent().getId().equals(x.getId()))
                            .toList().size() < x.getRemainSlot()) {
                        Attendance attendance = new Attendance();
                        attendance.setClassStudent(x);
                        attendance.setTrainHistory(trainHistory);
                        attendance.setStatus("NOT_YET");
                        attendances.add(attendance);
                    }
                });
                localDate = localDate.plusDays(1);
            }
        }
        trainHistoryRepo.saveAll(trainHistories);
        attendanceRepo.saveAll(attendances);
    }
}
