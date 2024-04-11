package com.example.happy_fitness.controller;

import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	@Autowired
	private FacilityService facilityService;

	@GetMapping
	public List<Facility> getAllContact(){
		return facilityService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Facility> getBlogById(@PathVariable("id") Long coachId){
		return new ResponseEntity<Facility>(facilityService.findById(coachId), HttpStatus.OK);
	}
}
