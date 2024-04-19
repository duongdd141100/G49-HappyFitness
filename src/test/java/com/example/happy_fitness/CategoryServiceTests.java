package com.example.happy_fitness;

import com.example.happy_fitness.entity.Category;
import com.example.happy_fitness.exception.ResourceNotFoundExeption;
import com.example.happy_fitness.repository.CategoryRepository;
import com.example.happy_fitness.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = G49HappyFitnessApplication.class)
public class CategoryServiceTests {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    public void checkFindAllCategoryTestcase01(){
        Category category1 = new Category();
        category1.setName("category1");
        Category category2 = new Category();
        category2.setName("category2");
        List<Category> categories = Arrays.asList(category1 , category2);
        Mockito.when(categoryRepository.findAll()).thenReturn(categories);
        List<Category> result = categoryService.findAll();
        Assertions.assertEquals(categories.size() , result.size());
    }

    @Test
    public void checkCreateTestcase01(){
        Category category1 = new Category();
        category1.setName("category1");
        Mockito.when(categoryRepository.save(category1)).thenReturn(category1);
        String result = categoryService.create(null , category1);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkUpdateTestcase01(){
        long id = 11;
        Category updateCategory = new Category();
        updateCategory.setName("abc123");
        Category categoryInDatabase = new Category();
        categoryInDatabase.setName("abc");
        Mockito.when(categoryRepository.findById(id)).thenReturn(Optional.of(categoryInDatabase));
        String result = categoryService.update(updateCategory , id , null);
        Assertions.assertEquals(HttpStatus.OK.getReasonPhrase() , result);
    }

    @Test
    public void checkUpdateTestcase02(){
        long id = 12;
        Category updateCategory = new Category();
        updateCategory.setName("abc123");
        Mockito.when(categoryRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(ResourceNotFoundExeption.class , () -> categoryService.update(updateCategory , id , null));
    }
}
