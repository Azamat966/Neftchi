package com.example.neftchi.dto.response;

import com.example.neftchi.model.enums.Language;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministrationResponce {
    private Long id;
    private String name_lastname;
    private String descriptions;
    private Language language;
    private String image;
}
