package com.example.happy_fitness.service;

import java.util.List;

import com.example.happy_fitness.entity.Blog;



public interface BlogService {
	Blog saveBlog(Blog blog);
	List<Blog> getAllBlog();
	Blog getBlogById(long id);
	Blog updateBlog(Blog blog, long id);
	void deleteBlog(long id);
}
