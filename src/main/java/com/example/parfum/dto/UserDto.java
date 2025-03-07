package com.example.parfum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private Long id;

    private String fullName;

    private String phone;

    private String address;

    private String password;
}
