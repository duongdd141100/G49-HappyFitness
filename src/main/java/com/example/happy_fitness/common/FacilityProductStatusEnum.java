package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum FacilityProductStatusEnum {
    COMING_SOON("Chưa bán"),
    OUT_OF_STOCK("Hết hàng"),
    STOP_SELL("Ngưng bán"),
    ACTIVE("Hoạt động");

    private final String value;

    FacilityProductStatusEnum(String value) {
        this.value = value;
    }
}
