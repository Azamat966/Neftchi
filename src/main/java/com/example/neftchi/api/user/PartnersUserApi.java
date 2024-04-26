package com.example.neftchi.api.user;
import com.example.neftchi.dto.response.PartnerResponce;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.service.PartnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/partners/user")
public class PartnersUserApi {
    private final PartnersService service;

    @GetMapping("find/all")
    public List<PartnerResponce> findAll() {
        return service.findAll();
    }
}

