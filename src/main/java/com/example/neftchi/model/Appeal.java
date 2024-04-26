package com.example.neftchi.model;

import com.example.neftchi.model.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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
    @Enumerated(EnumType.STRING)
    private Status status;
    private String file;
    private byte[] data;

    @OneToOne
    private AppealAnswer appealAnswer;
}
