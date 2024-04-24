package com.example.neftchi.service;

import com.example.neftchi.dto.response.AboutResponse;
import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.model.AboutCompany;
import com.example.neftchi.model.Services;
import com.example.neftchi.repository.AboutCompanyRepository;
import com.example.neftchi.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutCompanyService {
    private final AboutCompanyRepository serviceRepository;
    // Метод для обновления описания
    public AboutResponse updateDescriptions(Long id, String descriptions) {
        AboutCompany menuPage = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setDescriptions(descriptions);

        serviceRepository.save(menuPage);

        return AboutResponse.builder()
                .id(menuPage.getId())
                .tittle(menuPage.getTittle())
                .video(menuPage.getVideo()) // Исправил на "getVideo()" для получения видео
                .descriptions(menuPage.getDescriptions())
                .build();
    }


    // Метод для обновления видео
    public AboutResponse updateVideo(Long id, String video) {
        AboutCompany menuPage = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setVideo(video);

        serviceRepository.save(menuPage);

        return AboutResponse.builder()
                .id(menuPage.getId())
                .tittle(menuPage.getTittle())
                .video(menuPage.getVideo()) // Исправил на "getVideo()" для получения видео
                .descriptions(menuPage.getDescriptions())
                .build();
    }
    public AboutResponse updateTittle(Long id, String tittle) {
        AboutCompany menuPage = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setTittle(tittle);

        serviceRepository.save(menuPage);

        return AboutResponse.builder()
                .id(menuPage.getId())
                .tittle(menuPage.getTittle())
                .video(menuPage.getVideo())
                .descriptions(menuPage.getDescriptions())
                .build();
    }
    public List<AboutResponse> findAll() {
        List<AboutResponse> serviceResponse = new ArrayList<>();
        for (AboutCompany menuPage : serviceRepository.findAll()) {
            AboutResponse serviceResponse1 = new AboutResponse();
            serviceResponse1.setTittle(menuPage.getTittle());
            serviceResponse1.setDescriptions(menuPage.getDescriptions());
            serviceResponse1.setVideo(menuPage.getVideo());
            serviceResponse1.setId(menuPage.getId());
            serviceResponse.add(serviceResponse1);
        }
        return serviceResponse;
    }
    public void deleteByID(Long id) {
        AboutCompany menuPage = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setVideo(null);

        serviceRepository.save(menuPage);

    }
}