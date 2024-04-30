package com.example.neftchi.api.user;
import com.example.neftchi.dto.response.RegulationsResponce;
import com.example.neftchi.service.RegulationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/regulations/user")
public class RegulationsUserApi {
    private final RegulationsService service;

    @GetMapping("find/all")
    public List<RegulationsResponce> findAll() {
        return service.findAll();
    }
}