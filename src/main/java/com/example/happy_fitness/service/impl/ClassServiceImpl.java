package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.ClassStudent;
import com.example.happy_fitness.entity.Clazz;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.ClassRepository;
import com.example.happy_fitness.repository.ClassStudentRepository;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

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
    public List<Clazz> findAll(UserDetails userDetails) {
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
        return clazzes.stream().map(x -> {
            x.getPt().setFacility(null);
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
}
