package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.CreateNewsResponse;
import com.example.neftchi.dto.response.EmployeeResponse;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.CreateNewsRepository;
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
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/create/news/admin")
public class CreateNewsAdminApi {
    private final CreateNewsService service;
    private final CreateNewsRepository createNewsRepository;
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


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public String saveAppeal(@RequestParam String description,
                             @RequestParam String create_video,
                             @RequestParam String create_video_YouTobe,
                             @RequestParam Language language,
                             @RequestParam("file") MultipartFile file,
                             @RequestParam("create_image") MultipartFile create_image) {
        service.saveCreateNews(description, create_image, create_video, create_video_YouTobe, language, file);
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
    private CreateNewsResponse convertToEmployeeResponse(CreateNews createNews) {
        CreateNewsResponse response = new CreateNewsResponse();
        response.setId(createNews.getId());
        response.setCreate_image(createNews.getCreate_image());
        response.setCreate_video(createNews.getCreate_video());
        response.setLanguage(createNews.getLanguage());
        response.setDescriptions(createNews.getDescriptions());
        response.setImage(createNews.getImage());

        return response;
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
    @GetMapping("find/asc")
    public List<CreateNewsResponse> getEmplRepository(@RequestParam(name = "count") int count) {
        List<CreateNews> createNews = service.newsrepository(count);
        List<CreateNewsResponse> createNewsResponses = createNews.stream()
                .map(this::convertToEmployeeResponse)
                .collect(Collectors.toList());
        return createNewsResponses;
    }

    @GetMapping("find/desc")
    public List<CreateNewsResponse> getCreateNewsRepository(@RequestParam(name = "count") int count) {
        List<CreateNews> employees = service.createNewsrepository(count);
        List<CreateNewsResponse> createNewsResponses = employees.stream()
                .map(this::convertToEmployeeResponse)
                .collect(Collectors.toList());
        return createNewsResponses;
    }


    @GetMapping("/news")
    public List<CreateNewsResponse> findAllByCategory(@RequestParam String category) {
        return service.findAllByCategory(category);
    }


}





