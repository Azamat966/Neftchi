package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.MenuPageResponse;
import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.repository.MenuPageRepository;
import com.example.neftchi.service.MenuPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/menu/page/admin")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
public class MenuPageAdminApi {
    private final MenuPageService menuPageService;

    public MenuPageAdminApi(MenuPageService menuPageService) {
        this.menuPageService = menuPageService;
    }

    @PutMapping("/admin/menuPage/update/{id}")
    public MenuPageResponse updateTitle(
            @PathVariable Long id,
            @RequestParam String title
    ) {
        return menuPageService.updateTittle(id, title);
    }

    @PutMapping("/admin/menuPage/updateDescription/{id}") // Изменили адрес на уникальный
    public MenuPageResponse updateDescription(
            @PathVariable Long id,
            @RequestParam String description
    ) {
        return menuPageService.updateDescription(id, description);
    }

    @GetMapping("/admin/menuPage/find")
    public List<MenuPageResponse> getAll() {
        return menuPageService.findAll();
    }
}