package com.example.happy_fitness.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
@SqlResultSetMapping(
        name = "UserDto",
        classes = @ConstructorResult(
                targetClass = com.example.happy_fitness.dto.UserDto.class,
                columns = {
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "username", type = String.class),
                        @ColumnResult(name = "fullName", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "gender", type = Boolean.class),
                        @ColumnResult(name = "dob", type = Date.class),
                        @ColumnResult(name = "phoneNumber", type = String.class),
                        @ColumnResult(name = "address", type = String.class),
                        @ColumnResult(name = "roleName", type = String.class),
                        @ColumnResult(name = "facility", type = String.class),
                }
        )
)
public class User extends BaseEntity {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "path")
    private String path;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;
}
