package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Facility;

import java.util.List;

public interface ContactService {
	List<Facility> getAllContact();
	Facility getContactById(Float id);
}
