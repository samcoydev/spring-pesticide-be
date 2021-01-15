package com.example.pesticidebe.controller;

import com.example.pesticidebe.dto.UserDto;
import com.example.pesticidebe.model.User;
import com.example.pesticidebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/users")
@Table(name = "users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("getting users");
        return userService.findAll();
    }

    @PostMapping(path = "/register")
    public User saveUser(@Valid @RequestBody UserDto user) {
        System.out.println("saving user");
        return userService.save(user);
    }

}
