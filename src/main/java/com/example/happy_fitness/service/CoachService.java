package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.User;

import java.util.List;

public interface CoachService {
	List<User> getAllCoach();
	User getCoachById(Float id);
}
