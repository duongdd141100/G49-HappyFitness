package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.custom_repository.UserCustomRepository;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserCustomRepository userCustomRepo;

    @Override
    public List<User> findAllByCondition(String username, String fullName, String email, Boolean gender, Float roleId) {
        return userCustomRepo.findAllByCondition(username, fullName, email, gender, roleId);
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user, Float id) {
        return null;
    }

    @Override
    public void delete(Float id) {

    }
}
