package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.model.Adminstration;
import com.example.neftchi.model.Services;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.ServiceRepository;
import com.example.neftchi.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin/service")
@PreAuthorize("hasAuthority('ADMIN')")
public class ServiceAdminApi {
    private final ServicesService service;
    private final ServiceRepository serviceRepository;
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@RequestParam String link,
                       @RequestParam String title,
                       @RequestParam("file_image") MultipartFile file) {
        service.saveServices(link, title, file);
        return "Saved";
    }

    @GetMapping("/admin/menuPage/getById")
    public ServiceResponse getById(@RequestParam Long id){
        return service.getById(id);}


    @GetMapping("/admin/menuPage/find")
    public List<ServiceResponse> getAll() {
        return service.findAll();
    }
    @DeleteMapping("/menuPage/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteByID(id);
        return "deleted:"+id;
    }
    @PutMapping("/admin/menuPage/update/{id}")
    public ServiceResponse update(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String image,
            @RequestParam String link
    ) {
        return service.update(id, title, image, link);
    }
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Services services = serviceRepository.findById(id).orElseThrow();
        byte[] imageData = services.getData(); // Предполагается, что у Adminstration есть метод getData(), возвращающий массив байтов фотографии
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) // Устанавливаем MIME-тип изображения (JPEG в данном случае)
                .body(imageData); // Возвращаем массив байтов фотографии как тело ответа
    }
}