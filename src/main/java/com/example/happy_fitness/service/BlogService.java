package com.example.happy_fitness.service;

import java.math.BigInteger;
import java.util.List;

import com.example.happy_fitness.entity.Blog;



public interface BlogService {
	Blog saveBlog(Blog blog);
	List<Blog> getAllBlog();
	Blog getBlogById(BigInteger id);
	Blog updateBlog(Blog blog, BigInteger id);
	void deleteBlog(BigInteger id);
}
