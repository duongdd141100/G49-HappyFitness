package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.common.ErrorMessageEnum;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.CharBuffer;
import java.util.Arrays;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User validateUser(User user) {
        if (user != null && StringUtils.hasText(user.getUsername())) {
            User realUser = userRepo.findByUsername(user.getUsername());
            if (passwordEncoder.matches(CharBuffer.wrap(user.getPassword()), realUser.getPassword())) {
                return realUser;
            }
        }
        throw new RuntimeException(ErrorMessageEnum.LOGIN_FAILED.getCode());
    }

    @Override
    public User findByUsername(String issuer) {
        if (StringUtils.hasText(issuer)) {
            return userRepo.findByUsername(issuer);
        }
        throw new RuntimeException(ErrorMessageEnum.TOKEN_INVALID.getCode());
    }

    @Override
    public User save(User user) {
        if (Arrays.asList(user.getFullName(),
                user.getUsername(),
                user.getPassword(),
                user.getPhoneNumber(),
                user.getEmail()).stream().allMatch(StringUtils::hasText)
                && user.getGender() != null
                && user.getDob() != null
                && user.getRole().getId() != null) {
            if (userRepo.findByUsername(user.getUsername()) != null) {
                throw new RuntimeException(ErrorMessageEnum.USERNAME_EXIST.getCode());
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepo.save(user);
        }
        throw new RuntimeException(ErrorMessageEnum.LACK_OF_INFORMATION.getCode());
    }
}
