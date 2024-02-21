package com.example.happy_fitness.repository;

import com.example.happy_fitness.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Float> {
}
