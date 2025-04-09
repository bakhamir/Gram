package com.example.messenger.service;

import com.example.messenger.domain.User;
import com.example.messenger.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String phoneNumber, String password) {
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);  // Лучше использовать хеширование пароля
        return userRepository.save(user);
    }

    public Optional<User> login(String phoneNumber, String password) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .filter(user -> user.getPassword().equals(password));  // Лучше хешировать пароль
    }
}
