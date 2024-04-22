package com.example.neftchi.api.user;

import com.example.neftchi.service.MenuPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/menu/page/user")
public class MenuPageUserApi {
    private final MenuPageService menuPageService;
}
