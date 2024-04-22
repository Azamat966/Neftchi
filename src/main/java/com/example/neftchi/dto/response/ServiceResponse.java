package com.example.neftchi.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {
    private Long id;
    private String tittle;
    private String image;
    private String link;
}
