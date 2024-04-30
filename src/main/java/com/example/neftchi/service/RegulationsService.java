package com.example.neftchi.service;

import com.example.neftchi.model.Appeal;
import com.example.neftchi.model.Regulations;
import com.example.neftchi.model.enums.Status;
import com.example.neftchi.repository.RegulationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class RegulationsService {
private final RegulationsRepository repository;
    @Transactional
    public void saveRegulations(String regulations, MultipartFile file_pdf) {
        try {
            Regulations request = new Regulations();
            request.setRegulations(regulations);
            request.setFile_pdf(file_pdf.getOriginalFilename());
            request.setData(file_pdf.getBytes());
            repository.save(request);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload PDF file", e);
        }
    }
}

