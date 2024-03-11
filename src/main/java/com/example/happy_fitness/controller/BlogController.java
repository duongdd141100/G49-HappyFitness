package net.blog.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.blog.springboot.model.Blog;
import net.blog.springboot.service.BlogService;

@RestController
@RequestMapping("/api/blog")
public class BlogController {
	private BlogService blogService;


	
	public BlogController(BlogService blogService) {
		super();
		this.blogService = blogService;
	}



	// build create employee REST API
	@PostMapping()
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
		return new ResponseEntity<Blog>(blogService.saveBlog(blog), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Blog> getAllBlog(){
		return blogService.getAllBlog();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable("id") long blogId){
		return new ResponseEntity<Blog>(blogService.getBlogById(blogId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable("id") long id
												  ,@RequestBody Blog blog){
		return new ResponseEntity<Blog>(blogService.updateBlog(blog, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		// delete employee from DB
		blogService.deleteBlog(id);
		return new ResponseEntity<String>("Blog deleted successfully!.", HttpStatus.OK);
	}
}
