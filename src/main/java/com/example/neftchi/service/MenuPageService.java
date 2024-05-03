package com.example.neftchi.service;

import com.example.neftchi.dto.response.MenuPageResponse;
import com.example.neftchi.model.MenuPage;
import com.example.neftchi.repository.MenuPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuPageService {
    private final MenuPageRepository serviceRepository;

    public MenuPageResponse updateDescription(Long id, String descriptions) {
        MenuPage menuPage = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setDescription(descriptions);

        serviceRepository.save(menuPage);

        return MenuPageResponse.builder()
                .id(menuPage.getId())
                .descriptions(menuPage.getDescription())
                .tittle(menuPage.getTittle())
                .build();


    }

    public MenuPageResponse updateTittle(Long id, String tittle) {
        MenuPage menuPage = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setTittle(tittle);

        serviceRepository.save(menuPage);

        return MenuPageResponse.builder()
                .id(menuPage.getId())
                .tittle(menuPage.getTittle())
                .descriptions(menuPage.getDescription())
                .build();
    }

    public List<MenuPageResponse> findAll() {
        List<MenuPageResponse> menuPageResponses = new ArrayList<>();
        for (MenuPage menuPage : serviceRepository.findAll()) {
            MenuPageResponse serviceResponse1 = new MenuPageResponse();
            serviceResponse1.setTittle(menuPage.getTittle());
            serviceResponse1.setDescriptions(menuPage.getDescription());
            serviceResponse1.setId(menuPage.getId());
            menuPageResponses.add(serviceResponse1);
        }
        return menuPageResponses;

    }

}