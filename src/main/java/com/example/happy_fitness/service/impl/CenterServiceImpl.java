package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.repository.FacilityRepository;
import com.example.happy_fitness.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {

	@Autowired
	private FacilityRepository facilityRepo;

	@Override
	public List<Facility> getAllCenter() {
		return facilityRepo.findAll();
	}

	@Override
	public Facility getCenterById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
