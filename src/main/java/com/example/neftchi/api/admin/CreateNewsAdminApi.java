package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.CreateNewsResponse;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.service.CreateNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
