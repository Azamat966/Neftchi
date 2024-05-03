package com.example.neftchi.api.user;

import com.example.neftchi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category/user")
public class CategoryUserApi {
    private final CategoryService categoryService;

}
