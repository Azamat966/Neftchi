package com.example.neftchi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Appeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_lastname;
    private String numberTel;
    private String manyDescription;
    private String description;
    private String email;
    private String status;
    private String file;

    @OneToOne
    private AppealAnswer appealAnswer;
}
