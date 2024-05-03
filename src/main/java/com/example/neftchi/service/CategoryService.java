package com.example.neftchi.service;

import com.example.neftchi.dto.response.CategoryResponse;
import com.example.neftchi.model.Category;
import com.example.neftchi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryResponse save(String color,
                                 String category,
                                 int importance_number) {
        Category menuPage = new Category();
        menuPage.setColor(color);
        menuPage.setCategory(category);
        menuPage.setImportance_number(importance_number);
        categoryRepository.save(menuPage);
        return CategoryResponse.builder()
                .id(menuPage.getId())
                .color(menuPage.getColor())
                .category(menuPage.getCategory())
                .importance_number(menuPage.getImportance_number())
                .build();
    }
    public List<CategoryResponse> findAll (){
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categoryRepository.findAllOrderNumber()) {
            CategoryResponse categoryResponse1 = new CategoryResponse();
            categoryResponse1.setId(category.getId());
            categoryResponse1.setCategory(category.getCategory());
            categoryResponse1.setColor(category.getColor());
            categoryResponse1.setImportance_number(category.getImportance_number());
            categoryResponses.add(categoryResponse1);

        }
        return categoryResponses;


    }
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);

    }

    public CategoryResponse update(Long id,  String color ,String category , String importance_number) {
        Category category1  = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page found with id: " + id));
        category1.setColor(color);
        category1.setCategory(category);
        category1.setImportance_number(Integer.parseInt(importance_number));

        categoryRepository.save(category1);
        return CategoryResponse.builder()
                .id(category1.getId())
                .category(category1.getCategory())
                .color(category1.getColor())
                .importance_number(category1.getImportance_number())
                .build();
    }




    }









