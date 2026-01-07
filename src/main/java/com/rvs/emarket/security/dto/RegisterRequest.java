package com.rvs.emarket.security.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String email;
    private String role; // ejemplo: "ADMIN" o "USER"

}
