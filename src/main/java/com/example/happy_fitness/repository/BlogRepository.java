package com.example.happy_fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.happy_fitness.entity.Blog;



@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
