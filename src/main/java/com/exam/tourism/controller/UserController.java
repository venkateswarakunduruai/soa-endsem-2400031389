package com.exam.tourism.controller;

import com.exam.tourism.dto.UserResponse;
import com.exam.tourism.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User Management", description = "APIs to manage users (requires JWT)")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    private final UserService userService;

    // ── DISPLAY ALL USERS ─────────────────────────────────────────
    @GetMapping
    @Operation(summary = "Get all users", description = "Returns a list of all registered users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ── GET USER BY ID ────────────────────────────────────────────
    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID", description = "Returns a single user by their ID")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
