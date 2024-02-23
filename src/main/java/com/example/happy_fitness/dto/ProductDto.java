package com.example.happy_fitness.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Float facilityProductId;
    private String code;
    private String name;
    private String imagePath;
    private String category;
    private String supplier;
    private Float price;
    private String facility;
    private String status;
    private Integer stockQuantity;
}
