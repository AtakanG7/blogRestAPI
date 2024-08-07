package com.example.blogRestAPI.controller;

import com.example.blogRestAPI.dto.AuthResponseDTO;
import com.example.blogRestAPI.dto.LoginDTO;
import com.example.blogRestAPI.dto.SignUpDTO;
import com.example.blogRestAPI.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpDTO signUpDto) {
        authService.registerUser(signUpDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> authenticateUser(@Valid @RequestBody LoginDTO loginDto) {
        return ResponseEntity.ok(authService.authenticateUser(loginDto));
    }
}