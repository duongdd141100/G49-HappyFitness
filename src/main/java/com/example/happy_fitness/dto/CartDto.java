package com.example.happy_fitness.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CartDto {
    private BigInteger id;
    private BigInteger facilityProductId;
    private String code;
    private String name;
    private String image;
    private String category;
    private String supplier;
    private Float price;
    private Integer quantity;
}
