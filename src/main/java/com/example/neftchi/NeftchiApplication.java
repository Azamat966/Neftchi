package com.example.neftchi;

import com.example.neftchi.model.AboutCompany;
import com.example.neftchi.model.Category;
import com.example.neftchi.model.MenuPage;
import com.example.neftchi.model.User;
import com.example.neftchi.model.enums.Role;
import com.example.neftchi.repository.AboutCompanyRepository;
import com.example.neftchi.repository.CategoryRepository;
import com.example.neftchi.repository.MenuPageRepository;
import com.example.neftchi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class NeftchiApplication {
    private final MenuPageRepository menuPageRepository;
    private final AboutCompanyRepository aboutCompanyRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(NeftchiApplication.class, args);
    }

//    @PostConstruct
//    public void init() {
//        MenuPage menuPage = new MenuPage();
//        menuPage.setTittle("Нефтяная компания Neftchi");
//        menuPage.setDescription("Нефтяная компания Neftchi - символ мощи и надежности в мире энергетики.");
//        menuPageRepository.save(menuPage);
//        AboutCompany aboutCompany = new AboutCompany();
//        aboutCompany.setTittle("О компании");
//        aboutCompany.setDescriptions("Компания Neftchi - это ведущий участник нефтяного рынка");
//        aboutCompany.setVideo("Vide");
//        aboutCompanyRepository.save(aboutCompany);
//        User user = new User();
//        user.setEmail("jumaevameerim1@gmail.com");
//        user.setRole(Role.ADMIN);
//        user.setPassword(passwordEncoder.encode("123"));
//        userRepository.save(user);
//
//        Category category = new Category();
//        category.setCategory("a");
//        category.setColor("black");
//        category.setImportance_number(1);
//        categoryRepository.save(category);
//
//        Category category1 = new Category();
//        category1.setCategory("b");
//        category1.setColor("white");
//        category1.setImportance_number(2);
//        categoryRepository.save(category1);
//    }
}