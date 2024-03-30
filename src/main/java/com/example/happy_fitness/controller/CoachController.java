package com.example.happy_fitness.controller;

import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachController {
	private CoachService coachService;

	public CoachController(CoachService coachService) {
		super();
		this.coachService = coachService;
	}
	
	@GetMapping
	public List<User> getAllCoach(){
		return coachService.getAllCoach();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getBlogById(@PathVariable("id") Float coachId){
		return new ResponseEntity<User>(coachService.getCoachById(coachId), HttpStatus.OK);
	}
}
