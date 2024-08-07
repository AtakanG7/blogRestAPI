package com.example.blogRestAPI.service;

import com.example.blogRestAPI.dto.UserDTO;

public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO userDto);
}