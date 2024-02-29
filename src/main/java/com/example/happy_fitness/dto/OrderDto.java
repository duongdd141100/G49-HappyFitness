package com.example.happy_fitness.dto;

import lombok.Data;

@Data
public class OrderDto {
    private Float id;
    private String username;
    private String status;
    private String voucherCode;
    private String voucherName;
    private Float totalPrice;
    private Float discount;
    private Float price;
}
