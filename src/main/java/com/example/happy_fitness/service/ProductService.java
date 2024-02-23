package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Product;

import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<ProductDto> findProducts(Float facilityId, String status, Float categoryId, Float supplierId, Float price, Float maxPrice);

    ProductDto findProductDetail(Float facilityId, String code);
}
