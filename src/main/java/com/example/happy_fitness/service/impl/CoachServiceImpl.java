package com.example.happy_fitness.service.impl;

import java.math.BigInteger;
import java.util.List;

import com.example.happy_fitness.common.RoleEnum;
import com.example.happy_fitness.entity.User;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.UserRepository;
import com.example.happy_fitness.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAllCoach() {
		return userRepo.findAllByStatusIsTrueAndRole_Id(RoleEnum.ROLE_PERSONAL_TRAINER.getId());
	}

	@Override
	public User getCoachById(BigInteger id) {
		return userRepo.findById(id).orElseThrow(()->
		new ResourceNotFoundExeption("Coach", "ID", id));
	}

}
