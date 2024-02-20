package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findProducts(Float facilityId, String status, Float categoryId, Float supplierId, Float price, Float maxPrice);
}
