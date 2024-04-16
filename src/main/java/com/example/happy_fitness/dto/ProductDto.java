package com.example.happy_fitness.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private Long facilityProductId;
    private String code;
    private String name;
    private String imagePath;
    private String category;
    private Long supplierId;
    private String supplier;
    private Float price;
    private String facility;
    private String status;
    private Integer stockQuantity;
    private String description;
}
