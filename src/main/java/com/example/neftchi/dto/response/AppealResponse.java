package com.example.neftchi.dto.response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppealResponse {
    private String name_lastname;
    private String numberTel;
    private String manyDescription;
    private String description;
    private String email;
    private String status;
    private String file;

}
