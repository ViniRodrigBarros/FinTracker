package com.example.fintracker.service;


import com.example.fintracker.model.User;
import com.example.fintracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User registerUser(String email, String password, String username, String cpf, Date dateOfBirth) {
        User newUser = new User();
        newUser.setCpf(cpf);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setUsername(username);
        newUser.setDateOfBirth(dateOfBirth);


        System.out.println(newUser);
        return userRepository.save(newUser);
    }

    public User getUserById(long id) {
        return userRepository.findByid(id);
    }

}
