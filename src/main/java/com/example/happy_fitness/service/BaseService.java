package com.example.happy_fitness.service;

import jakarta.mail.MessagingException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface BaseService<T> {
    String create(UserDetails userDetails, T t);

    String update(T t, Long id, UserDetails userDetails) throws MessagingException;

    void delete(List<Long> ids);
}
