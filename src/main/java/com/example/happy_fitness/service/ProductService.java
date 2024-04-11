package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Product;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<ProductDto> findProducts(Long facilityId, String status, Long categoryId, Long supplierId, Float price, Float maxPrice);

    ProductDto findProductDetail(Long facilityId, String code);

    String createCustom(UserDetails userDetails, Product product, MultipartFile image) throws IOException;

    String updateCustom(Product product, Long id, MultipartFile image) throws IOException;

    void active(Long id);
}
