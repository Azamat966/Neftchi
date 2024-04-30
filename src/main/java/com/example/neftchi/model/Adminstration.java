package com.example.neftchi.model;

import com.example.neftchi.model.enums.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Adminstration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_lastname;
    private String descriptions;
    @Enumerated(EnumType.STRING)
    private Language language;
    private String image;
    private byte[] data;
}
