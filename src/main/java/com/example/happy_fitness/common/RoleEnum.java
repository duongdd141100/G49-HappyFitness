package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ROLE_ADMIN(1L, "Admin"),
    ROLE_MANAGER(2L, "Manager"),
    ROLE_CUSTOMER(3L, "Customer"),
    ROLE_RECEPTIONIST(4L, "Receptionist"),
    ROLE_PERSONAL_TRAINER(5L, "Personal Trainer");

    private final Long id;

    private final String value;

    RoleEnum(Long id, String value) {
        this.id = id;
        this.value = value;
    }
}
