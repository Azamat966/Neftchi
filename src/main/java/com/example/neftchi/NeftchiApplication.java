package com.example.neftchi;

import com.example.neftchi.model.AboutCompany;
import com.example.neftchi.model.MenuPage;
import com.example.neftchi.repository.AboutCompanyRepository;
import com.example.neftchi.repository.MenuPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class NeftchiApplication {
    private final MenuPageRepository menuPageRepository;
    private final AboutCompanyRepository aboutCompanyRepository;

    public static void main(String[] args) {
        SpringApplication.run(NeftchiApplication.class, args);
    }

    @PostConstruct
    public void init() {
        MenuPage menuPage = new MenuPage();
        menuPage.setTittle("Нефтяная компания Neftchi");
        menuPage.setDescription("Нефтяная компания Neftchi - символ мощи и надежности в мире энергетики.");
        menuPageRepository.save(menuPage);
        AboutCompany aboutCompany = new AboutCompany();
        aboutCompany.setTittle("О компании");
        aboutCompany.setDescriptions("Компания Neftchi - это ведущий участник нефтяного рынка");
        aboutCompany.setVideo("Vide");
        aboutCompanyRepository.save(aboutCompany);
    }
}