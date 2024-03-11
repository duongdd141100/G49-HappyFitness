package net.blog.springboot.service;

import java.util.List;

import net.blog.springboot.model.Blog;

public interface BlogService {
	Blog saveBlog(Blog blog);
	List<Blog> getAllBlog();
	Blog getBlogById(long id);
	Blog updateBlog(Blog blog, long id);
	void deleteBlog(long id);
}
