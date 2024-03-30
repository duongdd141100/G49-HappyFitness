package com.example.happy_fitness.controller;

import com.example.happy_fitness.entity.Facility;
import com.example.happy_fitness.service.CenterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class CenterController {
	private CenterService centerService;

	public CenterController(CenterService centerService) {
		super();
		this.centerService = centerService;
	}
	
	@GetMapping
	public List<Facility> getAllCenter(){
		return centerService.getAllCenter();
	}
}
