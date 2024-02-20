package com.example.happy_fitness.service.impl;

import com.example.happy_fitness.custom_repository.ProductCustomRepository;
import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductCustomRepository productCustomRepo;

    @Override
    public List<ProductDto> findProducts(Float facilityId, String status, Float categoryId, Float supplierId, Float minPrice, Float maxPrice) {
        return productCustomRepo.findProduct(facilityId, status, categoryId, supplierId, minPrice, maxPrice);
    }
}
