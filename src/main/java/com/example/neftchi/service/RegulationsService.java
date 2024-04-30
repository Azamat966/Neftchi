package com.example.neftchi.service;

import com.example.neftchi.dto.response.RegulationsResponce;
import com.example.neftchi.model.Regulations;
import com.example.neftchi.repository.RegulationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
