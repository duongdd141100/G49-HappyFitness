package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Facility;

import java.math.BigInteger;
import java.util.List;

public interface FacilityService extends BaseService<Facility> {

    List<Facility> findAll();

    Facility findById(BigInteger coachId);
}
