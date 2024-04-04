package com.example.happy_fitness.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface BaseService<T> {
    T create(UserDetails userDetails, T t);

    String update(T t, Float id, UserDetails userDetails);

    void delete(List<Float> ids);
}
