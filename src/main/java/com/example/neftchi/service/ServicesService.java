package com.example.neftchi.service;

import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.model.Services;
import com.example.neftchi.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesService {
    private final ServiceRepository serviceRepository;

    public ServiceResponse save(String tittle,
                                String image,
                                String link) {
        Services menuPage = new Services();
        menuPage.setTittle(tittle);
        menuPage.setImage(image);
        menuPage.setLink(link);
        serviceRepository.save(menuPage);
        return ServiceResponse.builder()
                .id(menuPage.getId())
                .tittle(menuPage.getTittle())
                .image(menuPage.getImage())
                .link(menuPage.getLink())
                .build();

    }

    public ServiceResponse findById(Long id) {
        Services menuPage = serviceRepository.findById(id).orElseThrow();
        return ServiceResponse.builder()
                .id( menuPage.getId())
                .tittle(menuPage.getTittle())
                .image(menuPage.getImage())
                .link(menuPage.getLink())
                .build();
    }

    public ServiceResponse getById(Long id) {
        Services menu = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find employee with this id: " + id));
        ServiceResponse response = new ServiceResponse();
        response.setId(menu.getId());
        response.setImage(menu.getImage());
        response.setLink(menu.getLink());
        response.setTittle(menu.getTittle());
        return response;
    }

    public ServiceResponse update(Long id, String tittle, String image, String link) {
        Services menuPage = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setTittle(tittle);
        menuPage.setImage(image);
        menuPage.setLink(link);

        serviceRepository.save(menuPage);

        return ServiceResponse.builder()
                .id(menuPage.getId())
                .tittle(menuPage.getTittle())
                .image(menuPage.getImage())
                .link(menuPage.getLink())
                .build();
    }

    public List<ServiceResponse> findAll() {
        List<ServiceResponse> serviceResponse = new ArrayList<>();
        for (Services menuPage : serviceRepository.findAll()) {
            ServiceResponse serviceResponse1 = new ServiceResponse();
            serviceResponse1.setTittle(menuPage.getTittle());
            serviceResponse1.setLink(menuPage.getLink());
            serviceResponse1.setImage(menuPage.getImage());
            serviceResponse1.setId(menuPage.getId());
            serviceResponse.add(serviceResponse1);
        }
        return serviceResponse;
    }

    public void deleteByID(Long id) {
        serviceRepository.deleteById(id);
    }
}