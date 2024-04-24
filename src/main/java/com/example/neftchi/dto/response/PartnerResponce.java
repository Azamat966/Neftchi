package com.example.neftchi.dto.response;

import com.example.neftchi.model.enums.Language;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerResponce {
    private Long id;
    private String image;
    private String tittle;
    private Language language;
    private String category;
    private String descriptions;
    private String link;
}
