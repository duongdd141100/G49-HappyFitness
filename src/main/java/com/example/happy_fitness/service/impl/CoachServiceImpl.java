package src.main.java.com.example.happy_fitness.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.blog.springboot.exception.ResourceNotFoundExeption;
import net.blog.springboot.model.Coach;
import net.blog.springboot.repository.CenterRepository;
import net.blog.springboot.repository.CoachRepository;
import net.blog.springboot.service.CoachService;
@Service
public class CoachServiceImpl implements CoachService {

	
	private CoachRepository coachRepository;
	
	
	public CoachServiceImpl(CoachRepository coachRepository) {
		super();
		this.coachRepository = coachRepository;
	}

	@Override
	public List<Coach> getAllCoach() {
		return coachRepository.findAll();
	}

	@Override
	public Coach getCoachById(long id) {
		return coachRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFoundExeption("Coach", "ID", id));
	}

}
