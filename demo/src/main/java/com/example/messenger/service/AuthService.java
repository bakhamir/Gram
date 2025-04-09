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

    // Внедрение зависимостей
    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Регистрация пользователя с хешированием пароля
    public User register(String phoneNumber, String password) {
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        // Хешируем пароль перед сохранением в базе данных
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    // Логин с проверкой пароля (сравниваем хешированный пароль)
    public Optional<User> login(String phoneNumber, String password) {
        return userRepository.findByPhoneNumber(phoneNumber)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));  // Проверка пароля с хешем
    }
}
