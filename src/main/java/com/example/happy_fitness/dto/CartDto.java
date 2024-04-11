package com.example.happy_fitness.dto;

import lombok.Data;

@Data
public class CartDto {
    private Long id;
    private Long facilityProductId;
    private String code;
    private String name;
    private String image;
    private String category;
    private String supplier;
    private Float price;
    private Integer quantity;
}
