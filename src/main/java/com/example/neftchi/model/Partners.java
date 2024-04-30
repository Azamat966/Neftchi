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
public class Partners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String tittle;
    private byte[] data;
    @Enumerated(EnumType.STRING)
    private Language language;
    private String category;
    private String descriptions;
    private String link;
}
