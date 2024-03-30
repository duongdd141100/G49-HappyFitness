package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Facility;

import java.util.List;

public interface CenterService {
	List<Facility> getAllCenter();
	Facility getCenterById(long id);
}
