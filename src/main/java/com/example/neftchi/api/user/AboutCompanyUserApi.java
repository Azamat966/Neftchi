package com.example.neftchi.api.user;

import com.example.neftchi.dto.response.AboutResponse;
import com.example.neftchi.service.AboutCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/about/company/user")
public class AboutCompanyUserApi {
    private final AboutCompanyService aboutCompanyService;
    @GetMapping("/admin/menuPage/find")
    public List<AboutResponse> getAll() {
        return aboutCompanyService.findAll();
    }
}