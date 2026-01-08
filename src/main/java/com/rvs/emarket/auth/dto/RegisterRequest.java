package com.rvs.emarket.auth.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String email;
    private String role; // ejemplo: "ADMIN" o "USER"

}
