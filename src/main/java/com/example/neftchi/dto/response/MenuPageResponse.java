package com.example.neftchi.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuPageResponse {
    private Long id;
    private String tittle;
    private String descriptions;
}