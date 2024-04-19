package com.example.happy_fitness;

import com.example.happy_fitness.entity.Blog;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.BlogRepository;
import com.example.happy_fitness.service.impl.BlogServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class BlogServiceTests {
    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogServiceImpl blogService;

    @Test
    public void checkSaveBlogTestcase01(){
        Blog blog = new Blog();
        blog.setTitle("title");
        blog.setContent("content");
        Mockito.when(blogRepository.save(blog)).thenReturn(blog);
        Blog returnedBlog = blogService.saveBlog(blog);
        Assertions.assertEquals(blog.getContent() , returnedBlog.getContent());
        Assertions.assertEquals(blog.getTitle() , returnedBlog.getTitle());
    }

    @Test
    public void checkGetBlogByIdTestcase01(){
        long id = 11;
        Mockito.when(blogRepository.findById(id)).thenReturn(Optional.of(new Blog()));
        Blog result = blogService.getBlogById(id);
        Assertions.assertNotNull(result);
    }

    @Test
    public void checkGetBlogByIdTestcase02(){
        long id = 12;
        Mockito.when(blogRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundExeption.class ,() -> blogService.getBlogById(id));
    }

    @Test
    public void checkDeleteBlogTestcase01(){
        long id = 11;
        Mockito.when(blogRepository.findById(id)).thenReturn(Optional.of(new Blog()));
        try {
            blogService.deleteBlog(id);
        }catch (Exception exception){
            Assertions.fail();
        }
    }

    @Test
    public void checkDeleteBlogTestcase02(){
        long id = 12;
        Mockito.when(blogRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundExeption.class ,() -> blogService.deleteBlog(id));
    }






}
