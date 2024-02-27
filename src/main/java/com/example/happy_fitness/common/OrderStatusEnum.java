package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    PROCESSING("Đang vận chuyển"),
    SUCCESSFULLY("Thành Công");

    private String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }
}
