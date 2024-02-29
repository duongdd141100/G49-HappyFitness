package com.example.happy_fitness.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface BaseService<T> {
    T create(UserDetails userDetails, T t);

    T update(T t, Float id);

    void delete(List<Float> ids);
}
