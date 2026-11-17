package com.exam.tourism.controller;

import com.exam.tourism.dto.*;
import com.exam.tourism.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Register and Login APIs")
public class AuthController {

    private final UserService userService;

    // ── REGISTER ─────────────────────────────────────────────────
    @PostMapping("/register")
    @Operation(summary = "Register a new user", description = "Add a new user to the system")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request) {
        UserResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }

    // ── LOGIN ─────────────────────────────────────────────────────
    @PostMapping("/login")
    @Operation(summary = "Login and get JWT token", description = "Authenticate user and return JWT")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = userService.loginUser(request);
        return ResponseEntity.ok(response);
    }
}
