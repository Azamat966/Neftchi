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
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private byte[] data;
    private String name;
    private String add_link;
    private String category;
    @Enumerated(EnumType.STRING)
    private Language language;
}
