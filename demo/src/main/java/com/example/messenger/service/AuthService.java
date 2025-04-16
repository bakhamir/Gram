package com.example.messenger.service;

import com.example.messenger.domain.User;
import com.example.messenger.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(String phoneNumber, String password) {
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return jwtService.generateToken(user); // Вернём токен
    }

    public Optional<String> login(String phoneNumber, String password) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .map(jwtService::generateToken);
    }
}
