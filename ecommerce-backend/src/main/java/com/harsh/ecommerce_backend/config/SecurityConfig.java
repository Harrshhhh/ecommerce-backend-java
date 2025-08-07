package com.harsh.ecommerce_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF for easier Postman/API testing
                .authorizeHttpRequests(auth -> auth
                        // Permit unauthenticated access to User and Product APIs
                        .requestMatchers("/api/users/**").permitAll()
                        .requestMatchers("/api/products/**").permitAll()
                        // Other requests require authentication
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
