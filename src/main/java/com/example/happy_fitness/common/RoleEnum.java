package com.example.happy_fitness.common;

import lombok.Getter;

import java.math.BigInteger;

@Getter
public enum RoleEnum {
    ROLE_ADMIN(BigInteger.valueOf(1), "Admin"),
    ROLE_MANAGER(BigInteger.valueOf(2), "Manager"),
    ROLE_CUSTOMER(BigInteger.valueOf(3), "Customer"),
    ROLE_RECEPTIONIST(BigInteger.valueOf(4), "Receptionist"),
    ROLE_PERSONAL_TRAINER(BigInteger.valueOf(5), "Personal Trainer");

    private final BigInteger id;

    private final String value;

    RoleEnum(BigInteger id, String value) {
        this.id = id;
        this.value = value;
    }
}
