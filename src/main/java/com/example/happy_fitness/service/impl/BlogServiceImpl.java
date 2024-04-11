package com.example.happy_fitness.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.happy_fitness.entity.Blog;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.BlogRepository;
import com.example.happy_fitness.service.BlogService;








@Service
public class BlogServiceImpl implements BlogService {

	
	private BlogRepository blogRepository;
	

	public BlogServiceImpl(BlogRepository blogRepository) {
		super();
		this.blogRepository = blogRepository;
	}
	
	@Override
	public Blog saveBlog(Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public List<Blog> getAllBlog() {
		return blogRepository.findAll();
	}

	@Override
	public Blog getBlogById(BigInteger id) {
//		Optional<Blog> blog = blogRepository.findById(id);
//		if(blog.isPresent()) {
//			return blog.get();
//		}else {
//			throw new ResourceNotFoundExeption("Blog", "ID", id);
//		}
		return blogRepository.findById(id).orElseThrow(()-> 
			new ResourceNotFoundExeption("Blog", "ID", id));
	}

	@Override
	public Blog updateBlog(Blog blog, BigInteger id) {
		Blog existingBlog = blogRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExeption("Blog", "Id", id));
		
		existingBlog.setCreateBy(blog.getCreateBy());
		existingBlog.setCreateDate(blog.getCreateDate());
		existingBlog.setUpdateBy(blog.getUpdateBy());
		existingBlog.setUpdateDate(blog.getUpdateDate());
		existingBlog.setContent(blog.getContent());
		existingBlog.setFilePath(blog.getFilePath());
		existingBlog.setLikeCount(blog.getLikeCount());
		existingBlog.setTitle(blog.getTitle());
		
		blogRepository.save(existingBlog);
		return existingBlog;
	}

	@Override
	public void deleteBlog(BigInteger id) {
		blogRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundExeption("Blog", "Id", id));
blogRepository.deleteById(id);
		
	}

	


}
