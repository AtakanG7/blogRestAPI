package com.example.blogRestAPI.service;

import com.example.blogRestAPI.dto.AuthResponseDTO;
import com.example.blogRestAPI.dto.LoginDTO;
import com.example.blogRestAPI.dto.SignUpDTO;
import com.example.blogRestAPI.entity.User;
import com.example.blogRestAPI.exception.ApiException;
import com.example.blogRestAPI.repository.UserRepository;
import com.example.blogRestAPI.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    public void registerUser(SignUpDTO signUpDto) {
        if(userRepository.existsByUsername(signUpDto.getUsername())) {
            throw new ApiException("Username is already taken!");
        }

        if(userRepository.existsByEmail(signUpDto.getEmail())) {
            throw new ApiException("Email is already in use!");
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        userRepository.save(user);
    }

    @Override
    public AuthResponseDTO authenticateUser(LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return new AuthResponseDTO(jwt);
    }
}