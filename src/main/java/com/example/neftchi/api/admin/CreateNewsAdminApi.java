package com.example.neftchi.api.admin;
import com.example.neftchi.model.Adminstration;
import com.example.neftchi.model.Appeal;
import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.AppealRepository;
import com.example.neftchi.repository.CreateNewsRepository;
import com.example.neftchi.service.AppealService;
import com.example.neftchi.service.CreateNewsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/create/news/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CreateNewsAdminApi {
    private final CreateNewsRepository createNewsRepository;
    private final CreateNewsService service;


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Upload a file")
    @Transactional
    public String saveAppeal(@RequestParam String description,
                             @RequestParam String create_video,
                             @RequestParam String create_video_YouTobe,
                             @RequestParam Language language,
                             @RequestParam("file") MultipartFile file,
                             @RequestParam("create_image") MultipartFile create_image) {
        service.saveCreateNews(description, create_image, create_video, create_video_YouTobe,language, file);
        return "Saved";
    }


    @GetMapping("/pdf/{id}")
    public ResponseEntity<ByteArrayResource> getPdf(@PathVariable Long id) throws IOException {
        CreateNews createNews = createNewsRepository.findById(id).orElseThrow();
        ByteArrayResource resource = new ByteArrayResource(createNews.getData());
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        CreateNews createNews = createNewsRepository.findById(id).orElseThrow();
        byte[] imageData = createNews.getData(); // Предполагается, что у Adminstration есть метод getData(), возвращающий массив байтов фотографии
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG) // Устанавливаем MIME-тип изображения (JPEG в данном случае)
                .body(imageData); // Возвращаем массив байтов фотографии как тело ответа
    }
}


