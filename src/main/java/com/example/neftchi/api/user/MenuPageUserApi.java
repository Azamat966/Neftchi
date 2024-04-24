package com.example.neftchi.api.user;

import com.example.neftchi.dto.response.MenuPageResponse;
import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.service.MenuPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/menu/page/user")
public class MenuPageUserApi {
    private final MenuPageService menuPageService;

    @GetMapping("/user/menuPage/find")
    public List<MenuPageResponse> getAll() {
        return menuPageService.findAll();
    }
}
