package com.example.drivenimbus.controller;

import com.example.drivenimbus.dto.UserLoginDTO;
import com.example.drivenimbus.dto.UserRegistrationRequestDTO;
import com.example.drivenimbus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequestDTO request) {
        userService.registerUser(request);
        return ResponseEntity.ok("Registration successful.Please check your email");
    }

    @GetMapping("/confirm")
    public ResponseEntity<String> confirmUser(@RequestParam String token) {
        userService.confirmEmail(token);
        return ResponseEntity.ok("Email confirmed! You can now log in");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO loginRequest) {
        userService.confirmLogin(loginRequest);
        return ResponseEntity.ok("Login successful");
    }
}
