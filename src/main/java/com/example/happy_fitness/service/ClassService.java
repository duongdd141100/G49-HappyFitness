package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Clazz;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ClassService extends BaseService<Clazz> {
    List<Clazz> findAll(UserDetails userDetails, String type);

    String createCustom(UserDetails userDetails, Clazz clazz, Long trainTimeId);
}
