package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ROLE_ADMIN("Admin"),
    ROLE_MANAGER("Manager"),
    ROLE_CUSTOMER("Customer"),
    ROLE_RECEPTIONIST("Receptionist"),
    ROLE_PERSONAL_TRAINER("Personal Trainer");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }
}
