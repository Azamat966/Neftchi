package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.CreateNewsResponse;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.service.CreateNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
public class CreateNewsAdminApi {
    private final CreateNewsService service;

    @PostMapping("/admin/save/create_News")
    public CreateNewsResponse save(@RequestParam List<String> create_Image,
                                   @RequestParam String creat_Video,
                                   @RequestParam String creat_pdf,
                                   @RequestParam String creat_Video_Youtube,
                                   @RequestParam String name,
                                   @RequestParam Language language,
                                   @RequestParam String description,
                                   @RequestParam Long id) {
        return service.save(create_Image,
                creat_Video,
                creat_pdf,
                creat_Video_Youtube,
                name,
                language,
                description,
                id);
    }

    @PutMapping("/updatePhoto")
    public void updatePhoto(@RequestParam String image,
                            @RequestParam Long id) {
        service.updatePhoto(image, id);
    }

    @DeleteMapping("/deletePhoto/{id}")
    public void deletePhoto(@PathVariable Long id) {
        service.deletePhoto(id);
    }

    @PutMapping("/create/admin/update/{id}")
    public CreateNewsResponse update(
            @RequestParam List<String> create_Image,
            @RequestParam String creat_Video,
            @RequestParam String creat_pdf,
            @RequestParam String creat_Video_Youtube,
            @RequestParam String name,
            @RequestParam String image,
            @RequestParam Language language,
            @RequestParam String description,
            @RequestParam Long id
    ) {
        return service.update(id, create_Image, image, creat_pdf, creat_Video, creat_Video_Youtube, description, name, language);
    }

    @DeleteMapping("/create/admin/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteByID(id);
        return "Удалено: " + id;
    }
    private final CreateNewsRepository createNewsRepository;
    private final CreateNewsService service;


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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


