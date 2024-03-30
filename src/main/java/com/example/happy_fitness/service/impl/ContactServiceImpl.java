package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.ContactRepository;
import com.example.happy_fitness.repository.FacilityRepository;
import com.example.happy_fitness.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private FacilityRepository facilityRepo;
	
	@Override
	public List<Facility> getAllContact() {
		return facilityRepo.findAll();
	}

	@Override
	public Facility getContactById(Float id) {
		return facilityRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundExeption("COntact", "ID", id));
	}

}
