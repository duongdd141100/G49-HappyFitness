package net.blog.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.blog.springboot.exception.ResourceNotFoundExeption;
import net.blog.springboot.model.Blog;
import net.blog.springboot.repository.BlogRepository;
import net.blog.springboot.service.BlogService;

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
	public Blog getBlogById(long id) {
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
	public Blog updateBlog(Blog blog, long id) {
		Blog existingBlog = blogRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundExeption("Blog", "Id", id));
		
		existingBlog.setPosterName(blog.getPosterName());
		existingBlog.setContent(blog.getContent());
		existingBlog.setTitle(blog.getTitle());
		
		blogRepository.save(existingBlog);
		return existingBlog;
	}


	@Override
	public void deleteBlog(long id) {
		blogRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundExeption("Blog", "Id", id));
		blogRepository.deleteById(id);
		
	}

}
