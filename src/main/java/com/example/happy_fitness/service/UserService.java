package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.UserDto;
import com.example.happy_fitness.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<UserDto> findAllByCondition(String requesterUsername, String username, String fullName, String email, Boolean gender, Float roleId);

    User create(String creatorUsername, User user);

    UserDto findUserDetail(UserDetails userDetails, String username);

    User resetPassword(UserDetails userDetails, String username);
}
