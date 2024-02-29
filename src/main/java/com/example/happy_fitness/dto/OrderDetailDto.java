package com.example.happy_fitness.dto;

import lombok.Data;

@Data
public class OrderDetailDto {
    private String productCode;
    private String productName;
    private String image;
    private Float unitPrice;
    private Integer quantity;
    private String facility;
}
