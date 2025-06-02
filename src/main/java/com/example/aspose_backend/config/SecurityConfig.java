package com.example.aspose_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    // Pour autoriser certaines routes sans authentification
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // désactive CSRF (utile pour Postman)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // autorise les appels à cette API sans login
                .anyRequest().authenticated() // les autres routes restent protégées
            )
            .httpBasic(Customizer.withDefaults()); // permet l'authentification HTTP de base (utile pour les tests)

        return http.build();
    }

    // Encoder pour les mots de passe
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
