package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @PostMapping("/auth/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login successful");
    }
}