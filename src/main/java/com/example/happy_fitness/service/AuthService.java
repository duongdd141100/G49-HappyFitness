package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.User;
import jakarta.mail.MessagingException;

public interface AuthService {
    User validateUser(User user);

    User findByUsername(String issuer);

    User save(User user);

    User editProfile(User user, User newUser);

    String changePassword(User user, String newPassword);

    String forgetPassword(String email) throws MessagingException;
}
