package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum FacilityProductStatusEnum {
    COMING_SOON("Chưa bán"),
    OUT_OF_STOCK("Hết hàng"),
    STOP_SELL("Ngưng bán"),
    ACTIVE("Hoạt động"),
    DEACTIVATE("Vô hiệu hóa");

    private final String value;

    FacilityProductStatusEnum(String value) {
        this.value = value;
    }

    public static FacilityProductStatusEnum typeOf(String name) {
        for (FacilityProductStatusEnum item : FacilityProductStatusEnum.values()) {
            if (item.name().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException(name);
    }
}
