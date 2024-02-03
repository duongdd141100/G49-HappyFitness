package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.User;
import jakarta.mail.MessagingException;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    UserDetails validateUser(User user);

    User findByUsername(String issuer);

    User save(User user);

    User editProfile(User user, User newUser);

    String changePassword(User user, String newPassword);

    String forgetPassword(String email) throws MessagingException;
}
