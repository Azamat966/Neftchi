package com.example.neftchi.dto.response;

import com.example.neftchi.model.enums.Language;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {
        private Long id;
        private String name_lastname;
        private String position;
        @Enumerated(EnumType.STRING)
        private Language language;
        private String description;
}
