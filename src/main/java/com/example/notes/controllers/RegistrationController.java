package com.example.notes.controllers;

import com.example.notes.dto.UserDto;
import com.example.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String addUser(@RequestBody UserDto userDto) {

        if (!userDto.getPassword().equals(userDto.getPasswordConfirm())) {
            return "Password not match";
        }

        if (!userService.saveUser(userDto)) {
            return "User already exists";
        }

        return "redirect:/";
    }
}
