package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum CustomerTickeActionEnum {
    BUY_NEW("Mua mới"),
    EXTEND("Gia hạn");

    private final String value;

    CustomerTickeActionEnum(String value) {
        this.value = value;
    }
}
