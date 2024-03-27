package src.main.java.com.example.happy_fitness.service;

import java.util.List;

import net.blog.springboot.model.Center;
import net.blog.springboot.model.Coach;

public interface CoachService {
	List<Coach> getAllCoach();
	Coach getCoachById(long id);
}
