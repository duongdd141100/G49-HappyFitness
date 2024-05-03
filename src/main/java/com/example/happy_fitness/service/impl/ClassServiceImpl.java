package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.*;
import com.example.happy_fitness.repository.*;
import com.example.happy_fitness.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ClassStudentRepository classStudentRepo;

    @Autowired
    private TrainScheduleRepository trainScheduleRepo;

    @Autowired
    private TrainTimeRepository trainTimeRepo;

    @Override
    public String create(UserDetails userDetails, Clazz clazz) {
        return null;
    }

    @Override
    public String update(Clazz clazz, Long id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public List<Clazz> findAll(UserDetails userDetails, String type) {
        User requester = userRepo.findByUsername(userDetails.getUsername());
        List<Clazz> clazzes;
        String requesterRole = userDetails.getAuthorities().stream().findFirst().get().getAuthority();
        if (RoleEnum.ROLE_ADMIN.name().equals(requesterRole)) {
            clazzes = classRepo.findAll();
        } else if (Arrays.asList(RoleEnum.ROLE_MANAGER.name(), RoleEnum.ROLE_RECEPTIONIST.name()).contains(requesterRole)) {
            clazzes = classRepo.findAllByPt_Facility(requester.getFacility());
        } else if (RoleEnum.ROLE_PERSONAL_TRAINER.name().equals(requesterRole)) {
            clazzes = classRepo.findAllByPt(requester);
        } else {
            clazzes = classStudentRepo.findAllByStudent(requester).stream().map(ClassStudent::getClazz).toList();
        }
        if (StringUtils.hasText(type)) {
            clazzes = clazzes.stream().filter(x -> x.getType().equals(type)).toList();
        }
        return clazzes.stream().map(x -> {
            x.getPt().getFacility().setManager(null);
            x.setClassStudents(x.getClassStudents().stream().map(classStudent -> {
                classStudent.setClazz(null);
                return classStudent;
            }).toList());
            x.setTrainSchedules(x.getTrainSchedules().stream().map(trainSchedule -> {
                trainSchedule.setClazz(null);
                return trainSchedule;
            }).toList());
            return x;
        }).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createCustom(UserDetails userDetails, Clazz clazz, Long trainTimeId) {
        clazz.setStatus("ACTIVE");
        clazz = classRepo.save(clazz);
        clazz.setType("ONE_ON_MANY");
        List<TrainSchedule> trainSchedules = new ArrayList<>();
        TrainTime trainTime = trainTimeRepo.findById(trainTimeId).get();
        for (Integer dayOfWeek = 2; dayOfWeek <= 7; dayOfWeek ++) {
            TrainSchedule trainSchedule = new TrainSchedule();
            trainSchedule.setTrainTime(trainTime);
            trainSchedule.setClazz(clazz);
            trainSchedule.setDayOfWeek(dayOfWeek);
            trainSchedules.add(trainSchedule);
        }
        trainScheduleRepo.saveAll(trainSchedules);
        return HttpStatus.OK.getReasonPhrase();
    }
}
