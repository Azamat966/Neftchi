package com.example.neftchi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppealRequest {
    private String name_lastname;
    private String numberTel;
    private String manyDescription;
    private String description;
    private String email;
    private String status;
    private String file;
}
