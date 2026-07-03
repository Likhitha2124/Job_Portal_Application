package com.likhitha.jobportal.controller;

import com.likhitha.jobportal.entity.User;
import com.likhitha.jobportal.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    private final UserRepository userRepository;
    public AuthController(UserRepository userRepository) { this.userRepository = userRepository; }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        if (userRepository.existsByEmail(user.getEmail())) return Map.of("success", false, "message", "Email already registered");
        user.setRole("USER");
        User saved = userRepository.save(user);
        return Map.of("success", true, "message", "Registered successfully", "userId", saved.getId(), "role", saved.getRole());
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())
                .<Map<String,Object>>map(u -> Map.of("success", true, "message", "Login successful", "userId", u.getId(), "name", u.getFullName(), "role", u.getRole()))
                .orElse(Map.of("success", false, "message", "Invalid email or password"));
    }
}
