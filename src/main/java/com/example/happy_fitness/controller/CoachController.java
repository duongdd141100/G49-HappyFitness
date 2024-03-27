package src.main.java.com.example.happy_fitness.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.blog.springboot.model.Blog;
import net.blog.springboot.model.Center;
import net.blog.springboot.model.Coach;
import net.blog.springboot.service.CenterService;
import net.blog.springboot.service.CoachService;

@RestController
@RequestMapping("/api/coach")
public class CoachController {
	private CoachService coachService;

	public CoachController(CoachService coachService) {
		super();
		this.coachService = coachService;
	}
	
	@GetMapping
	public List<Coach> getAllCoach(){
		return coachService.getAllCoach();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Coach> getBlogById(@PathVariable("id") long coachId){
		return new ResponseEntity<Coach>(coachService.getCoachById(coachId), HttpStatus.OK);
	}
}
