package com.example.neftchi.service;

import com.example.neftchi.dto.response.AdministrationResponce;
import com.example.neftchi.model.Adminstration;
import com.example.neftchi.model.Appeal;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.model.enums.Status;
import com.example.neftchi.repository.AdminstrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminstrationService {
    private final AdminstrationRepository adminstrationRepository;

    @Transactional
    public void saveAdminstrationl(String name_lastName, String descriptions, Language language, MultipartFile file) {
        try {
            Adminstration request = new Adminstration();
            request.setName_lastname(name_lastName);
            request.setDescriptions(descriptions);
            request.setLanguage(language);
            request.setImage(file.getOriginalFilename());
            request.setData(file.getBytes());
            adminstrationRepository.save(request);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload PDF file", e);
        }
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
