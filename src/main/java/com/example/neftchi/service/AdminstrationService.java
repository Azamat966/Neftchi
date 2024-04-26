package com.example.neftchi.service;

import com.example.neftchi.dto.response.AdministrationResponce;
import com.example.neftchi.model.Adminstration;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.AdminstrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminstrationService {
    private final AdminstrationRepository adminstrationRepository;

    public AdministrationResponce save(String name_lastname,
                                       String descriptions,
                                       Language language,
                                       String image) {
        Adminstration adminstration = new Adminstration();
        adminstration.setName_lastname(name_lastname);
        adminstration.setDescriptions(descriptions);
        adminstration.setLanguage(language);
        adminstration.setImage(image);
        adminstrationRepository.save(adminstration);
        return AdministrationResponce.builder()
                .id(adminstration.getId())
                .name_lastname(adminstration.getName_lastname())
                .descriptions(adminstration.getDescriptions())
                .language(adminstration.getLanguage())
                .image(adminstration.getImage())
                .build();

    }

    public AdministrationResponce update(Long id,
                                         String name_lastname,
                                         String descriptions,
                                         Language language,
                                         String image) {
        Adminstration adminstration = adminstrationRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        adminstration.setName_lastname(name_lastname);
        adminstration.setDescriptions(descriptions);
        adminstration.setLanguage(language);
        adminstration.setImage(image);
        adminstrationRepository.save(adminstration);
        return AdministrationResponce.builder()
                .id(adminstration.getId())
                .name_lastname(adminstration.getName_lastname())
                .descriptions(adminstration.getDescriptions())
                .language(adminstration.getLanguage())
                .image(adminstration.getImage())
                .build();
    }

    public void delete(Long id) {
        Adminstration adminstration = adminstrationRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        adminstrationRepository.delete(adminstration);
    }

    public List<AdministrationResponce> findAll() {
        List<AdministrationResponce> list = new ArrayList<>();
        for (Adminstration adminstration : adminstrationRepository.findAll()) {
            AdministrationResponce administrationResponce = new AdministrationResponce();
            administrationResponce.setName_lastname(adminstration.getName_lastname());
            administrationResponce.setDescriptions(adminstration.getDescriptions());
            administrationResponce.setLanguage(adminstration.getLanguage());
            administrationResponce.setImage(adminstration.getImage());
            administrationResponce.setId(adminstration.getId());
            list.add(administrationResponce);
        }
        return list;
    }
    public void updatePhoto(String image,Long id){
        Adminstration adminstration = adminstrationRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        adminstration.setImage(image);
        adminstrationRepository.save(adminstration);
    }
    public void deletePhoto(Long id){
        Adminstration adminstration = adminstrationRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        adminstration.setImage(null);
        adminstrationRepository.save(adminstration);
    }
}
