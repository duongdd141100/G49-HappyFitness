package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum CustomerTicketEnum {
    ACTIVE("Hoạt động"),
    EXPIRED("Hết hạn");

    private final String value;

    CustomerTicketEnum(String value) {
        this.value = value;
    }
}
