package com.example.neftchi.model;

import com.example.neftchi.model.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String code;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String fullName, String email, String password, String code, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.code = code;
        this.role = role;
    }

    public User() {
    }
}


