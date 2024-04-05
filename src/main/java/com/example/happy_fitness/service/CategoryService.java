package com.example.happy_fitness.service;

import com.example.happy_fitness.entity.Category;

import java.util.List;

public interface CategoryService extends BaseService<Category> {
    List<Category> findAll();
}
