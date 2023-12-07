package com.example.fintracker.service;

import com.example.fintracker.model.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static volatile AuthService instance;

    private final UserService userService;

    private AuthService(UserService userService) {
        this.userService = userService;
    }

    public static AuthService getInstance(UserService userService) {
        if (instance == null) {
            synchronized (AuthService.class) {
                if (instance == null) {
                    instance = new AuthService(userService);
                }
            }
        }
        return instance;
    }

    public boolean authenticate(String email, String password) {
        User user = userService.getUserByEmail(email);
        return user != null && user.getPassword().equals(password);
    }


}
