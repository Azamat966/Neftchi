//package com.example.neftchi.api.user;
//
//import com.example.neftchi.dto.response.ServiceResponse;
//import com.example.neftchi.service.ServicesService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/user/service")
//public class ServiceUserApi {
//    private final ServicesService service;
//
//    @GetMapping("/user/menuPage/find")
//    public List<ServiceResponse> getAll() {
//        return service.findAll();
//    }
//}
