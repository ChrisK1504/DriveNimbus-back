package com.example.drivenimbus.controller;


import com.example.drivenimbus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/password-reset")
public class PasswordResetController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostMapping("/request")
    public ResponseEntity<String> changePasswordRequest(@RequestBody Map<String, String> email) {
        String emailAddress = email.get("email");
        if (emailAddress == null) {
            return ResponseEntity.badRequest().body("Email address is required");
        }

        if (userService.changePasswordRequest( emailAddress )) {
            return ResponseEntity.ok("Password reset request sent to " + emailAddress);
        };
        return ResponseEntity.badRequest().body("Email address not found");
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyToken(@RequestParam String token) {
        if (userService.verifyToken( token )) {
            return ResponseEntity.ok("Token is valid. Please enter your new password.");
        }
        return ResponseEntity.badRequest().body("Invalid token or expired");
    }

    @PostMapping("/submit")
    public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> passwordReset) {
        String token = passwordReset.get("token");
        String password = passwordReset.get("password");
        if (token == null || password == null) {
            return ResponseEntity.badRequest().body("Token and password are required");
        }
        userService.resetPassword( token, password);
        return ResponseEntity.ok("Password reset successful");
    }
}
