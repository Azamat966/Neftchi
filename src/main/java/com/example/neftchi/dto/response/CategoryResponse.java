package com.example.neftchi.dto.response;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryResponse {
    private Long id;
    private String color;
    private String category;
    private int importance_number;
}