package com.example.neftchi.api.user;
import com.example.neftchi.dto.response.AdministrationResponce;
import com.example.neftchi.service.AdminstrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/adminstration/user")
public class AdminstrationUserApi {
    private final AdminstrationService service;
    @GetMapping("find/all")
    public List<AdministrationResponce> findAll(){
        return service.findAll();
    }
}
