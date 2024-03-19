package src.main.java.com.example.happy_fitness.service;

import java.util.List;


import net.blog.springboot.model.Center;

public interface CenterService {
	List<Center> getAllCenter();
	Center getCenterById(long id);
}
