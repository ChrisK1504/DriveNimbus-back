package com.example.drivenimbus.controller;

import com.example.drivenimbus.dto.UserRegistrationRequestDTO;
import com.example.drivenimbus.model.Users;
import com.example.drivenimbus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
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

    @Operation(summary = "Fetch all users // ADMIN")
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @Operation(summary = "Fetch user by userID // ADMIN")
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId) {
        Users user = userService.fetchUserById(userId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new user // ADMIN")
    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users user) {
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Update user's details // ADMIN")
    @PutMapping("/{userId}")
    public ResponseEntity<Users> updateUser(@RequestBody Users updatedUser, @PathVariable Long userId) {
        userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "Delete user by userID // ADMIN")
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        if (userService.deleteUserById(userId)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // TODO Add endpoints for CLIENT USERS (AUTHENTICATION IMPLEMENTATION)

}
