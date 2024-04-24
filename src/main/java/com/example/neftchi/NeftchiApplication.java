package com.example.neftchi;

import com.example.neftchi.model.User;
import com.example.neftchi.model.enums.Role;
import com.example.neftchi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@SpringBootApplication
public class NeftchiApplication {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(NeftchiApplication.class, args);
    }

    @PostConstruct
    public void init() {
        User user = new User();
        user.setEmail("jumaevameerim1@gmail.com");
        user.setRole(Role.ADMIN);
        user.setPassword(passwordEncoder.encode("123"));
        userRepository.save(user);
    }
}