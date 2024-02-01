package com.example.happy_fitness.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Float id;
    private String username;
    private String fullName;
    private String email;
    private Boolean gender;
    private Date dob;
    private String phoneNumber;
    private String address;
    private String roleName;
}
