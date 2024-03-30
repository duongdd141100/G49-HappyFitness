package com.example.happy_fitness.common;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ROLE_ADMIN(1F, "Admin"),
    ROLE_MANAGER(2F, "Manager"),
    ROLE_CUSTOMER(3F, "Customer"),
    ROLE_RECEPTIONIST(4F, "Receptionist"),
    ROLE_PERSONAL_TRAINER(5F, "Personal Trainer");

    private final Float id;

    private final String value;

    RoleEnum(Float id, String value) {
        this.id = id;
        this.value = value;
    }
}
