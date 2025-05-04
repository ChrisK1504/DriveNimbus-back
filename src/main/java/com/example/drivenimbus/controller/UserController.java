package com.example.drivenimbus.controller;

import com.example.drivenimbus.model.Users;
import com.example.drivenimbus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    HTTP Method | Endpoint | Purpose
//    POST | /users | Create a new user
//    GET | /users | Get all users
//    GET | /users/{id} | Get a user by ID
//    PUT | /users/{id} | Update a user's details
//    DELETE | /users/{id} | Delete a user

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId) {
        Users user = userService.fetchUserById(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        if (userService.deleteUserById(userId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }



}
