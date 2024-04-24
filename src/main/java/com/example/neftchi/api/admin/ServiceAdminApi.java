//package com.example.neftchi.api.admin;
//
//import com.example.neftchi.dto.response.ServiceResponse;
//import com.example.neftchi.service.ServicesService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("api/v1/admin/service")
//@PreAuthorize("hasAuthority('ADMIN')")
//public class ServiceAdminApi {
//    private final ServicesService service;
//    @PostMapping("/admin/save/menuPage")
//    public ServiceResponse save(@RequestParam String title,
//                                @RequestParam String image,
//                                @RequestParam String link) {
//        return service.save(title,image,link);
//    }
//    @GetMapping("/admin/menuPage/getById")
//    public ServiceResponse getById(@RequestParam Long id){
//        return service.getById(id);}
//
//
//    @GetMapping("/admin/menuPage/find")
//    public List<ServiceResponse> getAll() {
//        return service.findAll();
//    }
//    @DeleteMapping("/menuPage/delete/{id}")
//    public String deleteById(@PathVariable Long id) {
//        service.deleteByID(id);
//        return "deleted:"+id;
//    }
//    @PutMapping("/admin/menuPage/update/{id}")
//    public ServiceResponse update(
//            @PathVariable Long id,
//            @RequestParam String title,
//            @RequestParam String image,
//            @RequestParam String link
//    ) {
//        return service.update(id, title, image, link);
//    }
//}