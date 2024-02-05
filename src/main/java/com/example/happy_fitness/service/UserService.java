package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<User> findAllByCondition(String username, String fullName, String email, Boolean gender, Float roleId);

    User create(String creatorUsername, User user);
}
