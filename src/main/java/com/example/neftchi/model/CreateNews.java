package com.example.neftchi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CreateNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String create_image;
    private String create_video;
    private String create_pdf;
    private String create_video_YouTobe;
    private String name;
    private String language;
    private String descriptions;

    @OneToOne
    private Category category;
}
