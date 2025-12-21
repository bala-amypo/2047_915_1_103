package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Endpoints")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = userService.register(user); // Make sure register() exists in UserService
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    @Operation(summary = "Login user and return JWT token")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Make sure UserService has a login(email, password) method returning a JWT token
        String token = userService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
