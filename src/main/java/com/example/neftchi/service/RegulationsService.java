package com.example.neftchi.service;

import com.example.neftchi.dto.response.RegulationsResponce;
import com.example.neftchi.model.Regulations;
import com.example.neftchi.repository.RegulationsRepository;
import com.example.neftchi.model.Appeal;
import com.example.neftchi.model.Regulations;
import com.example.neftchi.model.enums.Status;
import com.example.neftchi.repository.RegulationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegulationsService {
    private final RegulationsRepository regulationsRepository;

    public RegulationsResponce save(String regulations,
                                    String file_pdf){
        Regulations regulations1 = new Regulations();
        regulations1.setRegulations(regulations);
        regulations1.setFile_pdf(file_pdf);
        regulationsRepository.save(regulations1);
        return RegulationsResponce.builder()
                .id(regulations1.getId())
                .regulations(regulations1.getRegulations())
                .file_pdf(regulations1.getFile_pdf())
                .build();
    }
    public RegulationsResponce update(Long id,
                                      String regulations,
                                      String file_pdf){
        Regulations regulations1 = regulationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        regulations1.setRegulations(regulations);
        regulations1.setFile_pdf(file_pdf);
        regulationsRepository.save(regulations1);
        return RegulationsResponce.builder()
                .id(regulations1.getId())
                .regulations(regulations1.getRegulations())
                .file_pdf(regulations1.getFile_pdf())
                .build();
    }
    public void delete(Long id){
        Regulations regulations = regulationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        regulationsRepository.delete(regulations);
    }
    public List<RegulationsResponce> findAll(){
        List<RegulationsResponce> regulationsResponces = new ArrayList<>();
        for (Regulations regulations : regulationsRepository.findAll()){
            RegulationsResponce regulationsResponce = new RegulationsResponce();
            regulationsResponce.setRegulations(regulations.getRegulations());
            regulationsResponce.setFile_pdf(regulations.getFile_pdf());
            regulationsResponce.setId(regulations.getId());
            regulationsResponces.add(regulationsResponce);
        }
        return regulationsResponces;
    }
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
