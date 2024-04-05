package com.example.happy_fitness.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Float productId;
    private Float facilityProductId;
    private String code;
    private String name;
    private String imagePath;
    private String category;
    private Float supplierId;
    private String supplier;
    private Float price;
    private String facility;
    private String status;
    private Integer stockQuantity;
    private String description;
}
