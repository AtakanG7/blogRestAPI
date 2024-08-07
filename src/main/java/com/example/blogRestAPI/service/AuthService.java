package com.example.blogRestAPI.service;

import com.example.blogRestAPI.dto.AuthResponseDTO;
import com.example.blogRestAPI.dto.LoginDTO;
import com.example.blogRestAPI.dto.SignUpDTO;

public interface AuthService {
    void registerUser(SignUpDTO signUpDto);
    AuthResponseDTO authenticateUser(LoginDTO loginDto);
}