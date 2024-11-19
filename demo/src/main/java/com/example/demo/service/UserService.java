package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Register user
    public ResponseEntity<?> registerUser(User user) {
        System.out.println("Registering user with email: " + user.getEmail());

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists with this email");
        }

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    // Login user
    public ResponseEntity<?> loginUser(User user) {
        System.out.println("Attempting login for user with email: " + user.getEmail());

        return ResponseEntity.ok("Login successful");
    }
}
