package com.example.neftchi.api.user;
import com.example.neftchi.dto.response.MiniPartnersRespons;
import com.example.neftchi.service.MiniPartnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/mini/partners/user")
public class MiniPartnersUserApi {
    private  final MiniPartnersService miniPartnersService;
    @GetMapping("/admin/miniPartners/findAll")
    public List<MiniPartnersRespons> getAll(){
        return miniPartnersService.findAll();
    }
}
