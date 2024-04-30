package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.PartnerResponce;
import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.Partners;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.PartnersRepository;
import com.example.neftchi.service.PartnersService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Partners/admin")
@PreAuthorize("hasAuthority('ADMIN')")

public class PartnersAdminApi {
    private final PartnersService service;
    private final PartnersRepository partnersRepository;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveAppeal(@RequestParam String description,
                             @RequestParam String title,
                             @RequestParam String link,
                             @RequestParam Language language,
                             @RequestParam String category,
                             @RequestParam("create_image") MultipartFile create_image) {
        service.savePartners(description,  title, link,category , language ,create_image );
        return "Saved";

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
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Partners partners = partnersRepository.findById(id).orElseThrow();
        byte[] imageData = partners.getData(); // Предполагается, что у Adminstration есть метод getData(), возвращающий массив байтов фотографии
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) // Устанавливаем MIME-тип изображения (JPEG в данном случае)
                .body(imageData); // Возвращаем массив байтов фотографии как тело ответа
    }
}