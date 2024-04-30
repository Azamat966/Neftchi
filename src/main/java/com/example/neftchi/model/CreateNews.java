package com.example.neftchi.model;

import com.example.neftchi.model.enums.Language;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CreateNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    @ElementCollection
    private List<String> create_image;
    private String create_video;
    private String file;
    private byte[] data;
    private String create_video_YouTobe;
    private String name;
    @Enumerated(EnumType.STRING)
    private Language language;
    private String descriptions;

    @ManyToOne
    private Category category;
}
