package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Product;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<ProductDto> findProducts(Float facilityId, String status, Float categoryId, Float supplierId, Float price, Float maxPrice);

    ProductDto findProductDetail(Float facilityId, String code);

    String createCustom(UserDetails userDetails, Product product, MultipartFile image) throws IOException;
}
