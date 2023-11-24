package com.example.fintracker.controller;

import com.example.fintracker.model.User;
import com.example.fintracker.service.AuthService;
import com.example.fintracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @Autowired
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        if (authService.authenticate(email, password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String cpf,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth
    ) {
        User newUser = userService.registerUser(email, username, password, cpf, dateOfBirth);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
