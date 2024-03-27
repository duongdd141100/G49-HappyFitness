package src.main.java.com.example.happy_fitness.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.blog.springboot.model.Blog;
import net.blog.springboot.model.Center;
import net.blog.springboot.service.BlogService;
import net.blog.springboot.service.CenterService;

@RestController
@RequestMapping("/api/center")
public class CenterController {
	private CenterService centerService;

	public CenterController(CenterService centerService) {
		super();
		this.centerService = centerService;
	}
	
	@GetMapping
	public List<Center> getAllCenter(){
		return centerService.getAllCenter();
	}
}
