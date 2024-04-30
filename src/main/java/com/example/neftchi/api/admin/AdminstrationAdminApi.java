package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.AdministrationResponce;
import com.example.neftchi.model.Adminstration;
import com.example.neftchi.model.Appeal;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.AdminstrationRepository;
import com.example.neftchi.service.AdminstrationService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/adminstration/admin")
@PreAuthorize("hasAuthority('ADMIN')")

public class AdminstrationAdminApi {
    private final AdminstrationService service;
    private final AdminstrationRepository adminstrationRepository;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@RequestParam String description,
                       @RequestParam String name_LastName,
                       @RequestParam Language language,
                       @RequestParam("file_image") MultipartFile file) {
        service.saveAdminstrationl(description, name_LastName, language, file);
        return "Saved";
    }

    @PutMapping("update")
    public AdministrationResponce update(
            @RequestParam Long id,
            @RequestParam String name_lastname,
            @RequestParam String descriptions,
            @RequestParam Language language,
            @RequestParam String image
    ) {
        return service.update(id, name_lastname, descriptions, language, image);
    }

    @DeleteMapping("delete")
    public void deletedById(@RequestParam Long id) {
        service.delete(id);
    }

    @GetMapping("find/all")
    public List<AdministrationResponce> findAll() {
        return service.findAll();
    }

    @PutMapping("delete/photo")
    public void deletephoto(@RequestParam Long id) {
        service.deletePhoto(id);
    }

    @PutMapping("update/photo")
    public void updatephoto(@RequestParam Long id, String image) {
        service.updatePhoto(image, id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Adminstration adminstration = adminstrationRepository.findById(id).orElseThrow();
        byte[] imageData = adminstration.getData(); // Предполагается, что у Adminstration есть метод getData(), возвращающий массив байтов фотографии
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) // Устанавливаем MIME-тип изображения (JPEG в данном случае)
                .body(imageData); // Возвращаем массив байтов фотографии как тело ответа
    }
}



