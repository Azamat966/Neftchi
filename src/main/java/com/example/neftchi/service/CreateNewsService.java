package com.example.neftchi.service;

import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.CreateNewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CreateNewsService {
   private final   CreateNewsRepository createNewsRepository;
    @Transactional
    public void saveCreateNews(String description, MultipartFile create_image, String create_video, String create_video_YouTobe, Language language , MultipartFile file) {
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
}
