package com.example.neftchi.service;

import com.example.neftchi.configuration.jwt.JwtUtils;
import com.example.neftchi.model.User;
import com.example.neftchi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.util.Optional;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    private final JavaMailSender sender;
    private final JwtUtils jwtUtils;

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow();
        if (bCryptPasswordEncoder.matches(password, ((User) user).getPassword())) {
            return jwtUtils.generateToken(user.getEmail());
        }
        return "invalid password";
    }

    public String randomNumber() {
        Random random = new Random();
        return String.valueOf(random.nextInt(0, 9)) +
                random.nextInt(0, 9) +
                random.nextInt(0, 9) +
                random.nextInt(0, 9) +
                random.nextInt(0, 9) +
                random.nextInt(0, 9);
    }

    public String confirmEmailSender(String email) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        String code = randomNumber();
        User user = userRepository.findByEmail(email).orElseThrow();
        user.setCode(code);
        try {
            helper.setTo(email);
            helper.setSubject("Code For confirm");
            helper.setText(code);
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sender.send(message);
        return code;
    }

    public String confirmEmail(String code, String email) {
        Optional<User> user = userRepository.findByEmail(email);
        boolean confirming = user.get().getCode().equals(code);
        if (confirming) {
            user.get().setCode(null);
            userRepository.save(user.get());
            return "confirmed";
        } else {
            return "no confirmed";
        }
    }

    public String forgotPassword(String email, String password, String pass) {
        if (comparePasswords(pass, password))
            throw new RuntimeException("Пароли совпадают.");
        Optional<User> user = userRepository.findByEmail(email);
        user.get().setPassword(bCryptPasswordEncoder.encode(password));
        user.get().setCode(null);
        userRepository.save(user.get());
        return "password sucseful chaened";
    }

    public static boolean comparePasswords(String password1, String password2) {
        if (password1.equals(password2)) {
            return true;
        } else {
            return false;
        }
    }
}


