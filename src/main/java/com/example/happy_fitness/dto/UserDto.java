package com.example.happy_fitness.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private Boolean gender;
    private Date dob;
    private String phoneNumber;
    private String address;
    private String roleName;
    private String facility;

    public UserDto(Long id, String username, String fullName, String email, Boolean gender, Date dob, String phoneNumber, String address,  String roleName, String facility) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.roleName = roleName;
        this.facility = facility;
    }
}
