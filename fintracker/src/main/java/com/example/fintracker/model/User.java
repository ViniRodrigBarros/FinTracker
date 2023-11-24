package com.example.fintracker.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Table(name = "user")
@Entity(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    private String email;
    @Getter
    private String password;
    @Getter
    private String username;
    @Getter
    private String cpf;
    @Getter
    private Date dateOfBirth;


    public User() {

    }

    public User(String email, String username, String password, String cpf, Date dateOfBirth) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}