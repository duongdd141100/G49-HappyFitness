package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    PROCESSING("Đang vận chuyển"),
    SUCCESSFULLY("Thành Công"),
    CANCELLED("Huỷ");

    private String value;

    OrderStatusEnum(String value) {
        this.value = value;
    }

    public static OrderStatusEnum typeOf(String name) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.name().equals(name)) {
                return orderStatusEnum;
            }
        }
        throw new IllegalArgumentException(name);
    }
}
