package com.example.neftchi.service;

import com.example.neftchi.dto.response.MiniPartnersRespons;
import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.model.MiniPartners;
import com.example.neftchi.model.Services;
import com.example.neftchi.repository.MiniPartnersRepository;
import com.fasterxml.classmate.AnnotationOverrides;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MiniPartnersService {
    private final MiniPartnersRepository miniPartnersRepository;


    public MiniPartnersRespons save(String cpdf,
                                    String conditions) {
        MiniPartners menuPage = new MiniPartners();
        menuPage.setConditions(conditions);
        menuPage.setCreate_pdf(cpdf);
        miniPartnersRepository.save(menuPage);
        return MiniPartnersRespons.builder()
                .id(menuPage.getId())
                .Conditions(menuPage.getConditions())
                .Create_Pdf(menuPage.getCreate_pdf())
                .build();
    }

    public List<MiniPartnersRespons> findAll() {
        List<MiniPartnersRespons> miniPartnersRespons = new ArrayList<>();
        for (MiniPartners miniPartners : miniPartnersRepository.findAll()) {
            MiniPartnersRespons miniPartnersRespons1 = new MiniPartnersRespons();
            miniPartnersRespons1.setId(miniPartners.getId());
            miniPartnersRespons1.setConditions(miniPartners.getConditions());
            miniPartnersRespons1.setCreate_Pdf(miniPartners.getCreate_pdf());
            miniPartnersRespons.add(miniPartnersRespons1);

        }
        return miniPartnersRespons;
    }

    public void deleteById(Long id) {
        miniPartnersRepository.deleteById(id);

    }

    public MiniPartnersRespons ubdate(Long id, String conditions) {
        MiniPartners miniPartners = miniPartnersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page found with id: " + id));
        miniPartners.setConditions(conditions);

        miniPartnersRepository.save(miniPartners);
        return MiniPartnersRespons.builder()
                .id(miniPartners.getId())
                .Conditions(miniPartners.getConditions())
                .Create_Pdf(miniPartners.getCreate_pdf())
                .build();
    }

    public MiniPartnersRespons ubdat(Long id, String cpdf) {
        MiniPartners miniPartners1 = miniPartnersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu page found with id: " + id));
        miniPartners1.setCreate_pdf(cpdf);


        miniPartnersRepository.save(miniPartners1);
        return MiniPartnersRespons.builder()
                .id(miniPartners1.getId())
                .Create_Pdf(miniPartners1.getCreate_pdf())
                .Create_Pdf(miniPartners1.getCreate_pdf())
                .build();


    }
}
