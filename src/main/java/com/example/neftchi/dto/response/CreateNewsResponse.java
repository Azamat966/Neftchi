package com.example.neftchi.dto.response;

import com.example.neftchi.model.enums.Language;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateNewsResponse {
    private Long id;
    private String image;
    private List <String > create_image;
    private String create_video;
    private String create_pdf;
    private String create_video_YouTobe;
    private String name;
    private String category;
    @Enumerated(EnumType.STRING)
    private Language language;
    private String descriptions;
}
