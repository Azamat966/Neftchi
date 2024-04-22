package com.example.neftchi;

import com.example.neftchi.model.AboutCompany;
import com.example.neftchi.model.MenuPage;
import com.example.neftchi.repository.MenuPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class NeftchiApplication {
    private final MenuPageRepository menuPageRepository;

    public static void main(String[] args) {
        SpringApplication.run(NeftchiApplication.class, args);
    }

    @PostConstruct
    public void init() {
        MenuPage menuPage = new MenuPage();
        menuPage.setTittle("Нефтяная компания Neftchi");
        menuPage.setDescriptions("Нефтяная компания Neftchi - символ мощи и \n надежности в мире энергетики.\n" +
                "обеспечивающая стабильное производство и \n поставку качественной нефти по всему миру,\n" + " основанный на инновациях, технологиях и \n экологической ответственности.");
        menuPageRepository.save(menuPage);
        AboutCompany aboutCompany = new AboutCompany();
        aboutCompany.setTittle("О компании");
        aboutCompany.setDescriptions("");
        aboutCompany.setVideo("Vidio");

    }
}