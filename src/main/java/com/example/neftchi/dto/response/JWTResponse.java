package com.example.neftchi.dto.response;

import com.example.neftchi.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTResponse {
    private String email;
    private String token;
    private String message;

    public JWTResponse(String email, String token, String azamat, Role role) {
    }
}