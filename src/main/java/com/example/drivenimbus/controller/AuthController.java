package com.example.drivenimbus.controller;

import com.example.drivenimbus.dto.UserLoginDTO;
import com.example.drivenimbus.dto.UserRegistrationRequestDTO;
import com.example.drivenimbus.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Operation(summary = "Handle a new user trying to register request")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequestDTO request) {
        userService.registerUser(request);
        return ResponseEntity.ok("Registration successful.Please check your email");
    }

    @Operation(summary = "Verify confirmation email")
    @GetMapping("/confirm")
    public ResponseEntity<String> confirmUser(@RequestParam String token) {
        userService.confirmEmail(token);
        return ResponseEntity.ok("Email confirmed! You can now log in");
    }

    @Operation(summary = "Handle a user login")
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO loginRequest) {
        userService.confirmLogin(loginRequest);
        return ResponseEntity.ok("Login successful");
    }
}
