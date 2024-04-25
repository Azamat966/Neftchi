package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.PartnerResponce;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.service.PartnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Partners/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class PartnersAdminApi {
    private final PartnersService service;

    @PostMapping("/save")
    public PartnerResponce save(@RequestParam String tittle,
                                @RequestParam String image,
                                @RequestParam String link,
                                @RequestParam Language language,
                                @RequestParam String category,
                                @RequestParam String descriptions) {
        return service.save(tittle, image, link, language, category, descriptions);
    }

    @PutMapping("update")
    public PartnerResponce update(
            @RequestParam Long id,
            @RequestParam String title,
            @RequestParam String image,
            @RequestParam String link,
            @RequestParam Language language,
            @RequestParam String category,
            @RequestParam String descriptions
    ) {
        return service.update(id, title, image, link, language, category, descriptions);
    }

    @DeleteMapping("delete")
    public void deleteById(@RequestParam Long id) {
        service.delete(id);
    }

    @GetMapping("find/all")
    public List<PartnerResponce> findAll() {
        return service.findAll();
    }
}