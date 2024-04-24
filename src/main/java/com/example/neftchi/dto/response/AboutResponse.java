package com.example.neftchi.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AboutResponse {
    private Long id;
    private String tittle;
    private String descriptions;
    private String video;

}