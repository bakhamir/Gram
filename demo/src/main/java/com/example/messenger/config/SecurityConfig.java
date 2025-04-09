package com.example.messenger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration  // Указывает, что это конфигурационный класс Spring
public class SecurityConfig {

    @Bean  // Создаем бин BCryptPasswordEncoder
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
