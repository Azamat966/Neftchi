package com.example.neftchi.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegulationsResponce {
    private Long id;
    private String regulations;
    private String file_pdf;

}
