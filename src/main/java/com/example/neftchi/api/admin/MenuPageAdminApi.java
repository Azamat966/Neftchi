package com.example.neftchi.api.admin;
import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.repository.MenuPageRepository;
import com.example.neftchi.service.MenuPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/menu/page/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class MenuPageAdminApi {
    private final MenuPageService menuPageService;

}