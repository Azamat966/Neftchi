package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.AdministrationResponce;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.service.AdminstrationService;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/adminstration/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminstrationAdminApi {
    private final AdminstrationService service;

    @PostMapping("/save")
    public AdministrationResponce save(@RequestParam String name_lastname,
                                       @RequestParam String descriptions,
                                       @RequestParam Language language,
                                       @RequestParam String image){
        return service.save(name_lastname,descriptions,language,image);
    }
    @PutMapping("update")
    public AdministrationResponce update(
            @RequestParam Long id,
            @RequestParam String name_lastname,
            @RequestParam String descriptions,
            @RequestParam Language language,
            @RequestParam String image
    ) {
        return service.update(id,name_lastname,descriptions,language,image);
    }
    @DeleteMapping("delete")
    public void deletedById(@RequestParam Long id){
        service.delete(id);
    }
    @GetMapping("find/all")
    public List<AdministrationResponce> findAll(){
        return service.findAll();
    }
    @PutMapping("delete/photo")
    public void deletephoto(@RequestParam Long id){
        service.deletePhoto(id);
    }
    @PutMapping("update/photo")
    public void updatephoto(@RequestParam Long id,String image){
        service.updatePhoto(image, id);
    }
}
