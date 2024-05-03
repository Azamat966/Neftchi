package com.example.neftchi.service;
import com.example.neftchi.model.Appeal;
import com.example.neftchi.model.enums.Status;
import com.example.neftchi.repository.AppealRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class AppealService {
    private final AppealRepository appealRepository;



    public AppealService(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }




    @Transactional
    public void saveAppeal(String description, String email, String lastName, String manyDescription, String numberTel, MultipartFile file) {
        try {
            Appeal request = new Appeal();
            request.setDescription(description);
            request.setStatus(Status.UNANSWERED);
            request.setEmail(email);
            request.setName_lastname(lastName);
            request.setNumberTel(numberTel);
            request.setManyDescription(manyDescription);
            request.setFile(file.getOriginalFilename());
            request.setData(file.getBytes());
            appealRepository.save(request);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload PDF file", e);
        }
    }
}