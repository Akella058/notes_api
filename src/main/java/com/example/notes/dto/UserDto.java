package com.example.notes.dto;

import lombok.Data;

@Data
public class UserDto {

    private String username;

    private String password;

    private String passwordConfirm;
}
