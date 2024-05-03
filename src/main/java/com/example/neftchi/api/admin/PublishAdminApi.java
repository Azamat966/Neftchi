package com.example.neftchi.api.admin;
import com.example.neftchi.model.Partners;
import com.example.neftchi.model.Publish;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.PublishRepository;
import com.example.neftchi.service.PublishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/Publish/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class PublishAdminApi {
    private  final  PublishService service;
    private  final PublishRepository publishRepository;
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String saveAppeal(@RequestParam String name,
                             @RequestParam String link,
                             @RequestParam Language language,
                             @RequestParam String category,
                             @RequestParam("create_image") MultipartFile create_image) {
        service.savePublish(name,   link,category , language ,create_image );
        return "Saved";

    }
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Publish publish = publishRepository.findById(id).orElseThrow();
        byte[] imageData = publish.getData(); // Предполагается, что у Adminstration есть метод getData(), возвращающий массив байтов фотографии
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) // Устанавливаем MIME-тип изображения (JPEG в данном случае)
                .body(imageData); // Возвращаем массив байтов фотографии как тело ответа
    }

}
