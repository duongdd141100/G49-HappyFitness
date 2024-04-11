package com.example.happy_fitness.service;

import java.util.List;

import com.example.happy_fitness.entity.Blog;



public interface BlogService {
	Blog saveBlog(Blog blog);
	List<Blog> getAllBlog();
	Blog getBlogById(Long id);
	Blog updateBlog(Blog blog, Long id);
	void deleteBlog(Long id);
}
