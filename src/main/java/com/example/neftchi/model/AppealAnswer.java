package com.example.neftchi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AppealAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    @OneToOne
    @JoinColumn(name = "appeal_answer")
    private Appeal appeal;
}
