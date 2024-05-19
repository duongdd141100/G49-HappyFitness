package com.example.happy_fitness.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private Long id;
    private String username;
    private String status;
    private String voucherCode;
    private String voucherName;
    private Float totalPrice;
    private Float discount;
    private Float price;
    private Boolean paid;
    private Date createdDate;
}
