package com.example.blogRestAPI.dto;

import javax.validation.constraints.NotBlank;

public class LoginDTO {
    @NotBlank
    private String usernameOrEmail;

    @NotBlank
    private String password;

    public @NotBlank String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setUsernameOrEmail(@NotBlank String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }
}