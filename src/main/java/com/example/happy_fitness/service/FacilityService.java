package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Facility;

import java.util.List;

public interface FacilityService extends BaseService<Facility> {

    List<Facility> findAll();

    Facility findById(Float coachId);
}
