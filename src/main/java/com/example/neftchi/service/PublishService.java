package com.example.neftchi.service;

import com.example.neftchi.model.Partners;
import com.example.neftchi.model.Publish;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.PartnersRepository;
import com.example.neftchi.repository.PublishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PublishService {
    private final PublishRepository publishRepository;

    @Transactional
    public void savePublish(String category, String name, String link, Language language, MultipartFile file) {
        try {
            Publish request = new Publish();
            request.setCategory(category);
            request.setName(name);
            request.setLanguage(language);
            request.setCategory(category);
            request.setAdd_link(link);
            request.setImage(file.getOriginalFilename());
            request.setData(file.getBytes());
            publishRepository.save(request);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload PDF file", e);
        }
    }
}
