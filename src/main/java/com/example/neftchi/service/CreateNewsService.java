package com.example.neftchi.service;

import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.CreateNewsRepository;
import com.example.neftchi.dto.response.CreateNewsResponse;
import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.model.Category;
import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.Services;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.CategoryRepository;
import com.example.neftchi.repository.CreateNewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateNewsService {
    private final CreateNewsRepository createNewsRepository;

    @Transactional
    public void saveCreateNews(String description, MultipartFile create_image, String create_video, String create_video_YouTobe, Language language, MultipartFile file) {
        try {
            CreateNews request = new CreateNews();
            request.setCreate_video(create_video);
            request.setDescriptions(description);
            request.setCreate_video_YouTobe(create_video_YouTobe);
            request.setLanguage(language);
            request.setFile(file.getOriginalFilename());
            request.setData(file.getBytes());
            createNewsRepository.save(request);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload PDF file", e);
        }
    }

    private final CategoryRepository categoryRepository;

    public CreateNewsResponse save(List<String> create_Image,
                                   String creat_Video,
                                   String creat_pdf,
                                   String creat_Video_Youtube,
                                   String name,
                                   Language language,
                                   String description,
                                   Long id) {
        CreateNews menuPage = new CreateNews();
        Category category = categoryRepository.findById(id).orElseThrow();
        menuPage.setCreate_image(create_Image);
        menuPage.setCreate_video(creat_Video);
        menuPage.setCreate_video_YouTobe(creat_Video_Youtube);
        menuPage.setCategory(category);
        menuPage.setName(name);
        menuPage.setLanguage(language);
        menuPage.setDescriptions(description);
        createNewsRepository.save(menuPage);
        return CreateNewsResponse.builder()
                .create_image(menuPage.getCreate_image())
                .id(menuPage.getId())
                .image(menuPage.getImage())
                .create_video(menuPage.getCreate_video())
                .create_video_YouTobe(menuPage.getCreate_video_YouTobe())
                .descriptions(menuPage.getDescriptions())
                .name(menuPage.getName())
                .language(menuPage.getLanguage())
                .category(category.getCategory())
                .build();
    }

    public CreateNewsResponse update(Long id, List<String> creat_image, String image,
                                     String creat_pdf,
                                     String creat_video,
                                     String creat_video_youtube,
                                     String description,
                                     String name,
                                     Language language) {
        CreateNews menuPage = createNewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));

        menuPage.setImage(image);
        menuPage.setCreate_image(creat_image);
        menuPage.setCreate_video(creat_video);
        menuPage.setCreate_video_YouTobe(creat_video_youtube);
        menuPage.setDescriptions(description);
        menuPage.setName(name);
        menuPage.setLanguage(language);
        createNewsRepository.save(menuPage);

        return CreateNewsResponse.builder()
                .id(menuPage.getId())
                .create_image(menuPage.getCreate_image())
                .image(menuPage.getImage())
                .category(menuPage.getCategory().getCategory())
                .descriptions(menuPage.getDescriptions())
                .create_video_YouTobe(menuPage.getCreate_video_YouTobe())
                .language(menuPage.getLanguage())
                .name(menuPage.getName())
                .create_video(menuPage.getCreate_video())
                .build();
    }

    public void updatePhoto(String image, Long id) {
        CreateNews createNews = createNewsRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        createNews.setImage(image);
        createNewsRepository.save(createNews);
    }

    public void deletePhoto(Long id) {
        CreateNews createNews = createNewsRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        createNews.setImage(null);
        createNewsRepository.save(createNews);
    }

    public void deleteByID(Long id) {
        createNewsRepository.deleteById(id);
    }

}
