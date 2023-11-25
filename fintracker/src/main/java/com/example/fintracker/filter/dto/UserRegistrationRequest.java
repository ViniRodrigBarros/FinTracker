package com.example.fintracker.filter.dto;


import lombok.Data;

import java.util.Date;

@Data
public class UserRegistrationRequest {
    private String email;
    private String username;
    private String password;
    private String cpf;
    private Date dateOfBirth;
}