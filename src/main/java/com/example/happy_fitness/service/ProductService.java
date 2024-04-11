package com.example.happy_fitness.service;

import com.example.happy_fitness.dto.ProductDto;
import com.example.happy_fitness.entity.Product;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public interface ProductService extends BaseService<Product> {
    List<ProductDto> findProducts(BigInteger facilityId, String status, BigInteger categoryId, BigInteger supplierId, Float price, Float maxPrice);

    ProductDto findProductDetail(BigInteger facilityId, String code);

    String createCustom(UserDetails userDetails, Product product, MultipartFile image) throws IOException;

    String updateCustom(Product product, BigInteger id, MultipartFile image) throws IOException;

    void active(BigInteger id);
}
