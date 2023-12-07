package com.example.fintracker.controller;

import com.example.fintracker.model.User;
import com.example.fintracker.service.AuthService;
import com.example.fintracker.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> login(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        if (authService.authenticate(email, password)) {
            User userDetails = userService.getUserByEmail(email);

            return new  ResponseEntity<>(userDetails,HttpStatus.OK);

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser
    ) {
        System.out.println(newUser.getPassword());
        System.out.println("test");
        User user = userService.registerUser(
                newUser.getEmail(),
                newUser.getPassword(),
                newUser.getUsername(),
                newUser.getCpf(),
                newUser.getDateOfBirth()

        );

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.getUserById(Long.parseLong(id));
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}