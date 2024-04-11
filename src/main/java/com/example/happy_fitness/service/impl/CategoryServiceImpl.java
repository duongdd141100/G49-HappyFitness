package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.entity.Category;
import com.example.happy_fitness.repository.CategoryRepository;
import com.example.happy_fitness.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public Category create(UserDetails userDetails, Category category) {
        return null;
    }

    @Override
    public String update(Category category, Long id, UserDetails userDetails) {
        return null;
    }

    @Override
    public void delete(List<Long> ids) {

    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
