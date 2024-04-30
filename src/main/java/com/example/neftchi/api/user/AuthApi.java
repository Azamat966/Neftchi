package com.example.neftchi.api.user;

import com.example.neftchi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthApi {


    private final AuthService authService;

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password) {
        return authService.login(email, password);
    }

    @PutMapping("/update-password")
    public ResponseEntity<String> updatePassword(
            @RequestParam String email,
            @RequestParam String newPassword,
            @RequestParam String password) {
        return ResponseEntity.ok(authService.forgotPassword(email, newPassword,password));
    }


    @GetMapping("/send-code-for-update-password")
    public ResponseEntity<String> sendCodeForUpdatePassword(@RequestParam String email) {
        if (email != null && !email.isEmpty()) {
            String code = authService.confirmEmailSender(email);
            return ResponseEntity.ok("Verification code sent to email: " + email);
        } else {
            return ResponseEntity.badRequest().body("Failed to send verification code: user email not found");
        }
    }

    @PostMapping("check/code")
    public String check(@RequestParam String email,
                        @RequestParam String code) {
        return authService.confirmEmail(code, email);
    }
}

