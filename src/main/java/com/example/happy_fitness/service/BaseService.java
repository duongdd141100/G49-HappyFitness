package com.example.happy_fitness.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.List;

public interface BaseService<T> {
    T create(UserDetails userDetails, T t);

    String update(T t, BigInteger id, UserDetails userDetails);

    void delete(List<BigInteger> ids);
}
