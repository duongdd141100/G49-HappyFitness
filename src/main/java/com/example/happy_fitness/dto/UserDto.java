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
    private String facility;
    private String roleName;

    public UserDto(Float id, String username, String fullName, String email, Boolean gender, Date dob, String phoneNumber, String address, String facility, String roleName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.facility = facility;
        this.roleName = roleName;
    }
}
