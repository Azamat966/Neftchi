package com.example.neftchi.service;

import com.example.neftchi.dto.response.PartnerResponce;
import com.example.neftchi.model.Partners;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.PartnersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnersService {
    private final PartnersRepository partnersRepository;

    public PartnerResponce save(String tittle,
                                String image,
                                String link,
                                Language language,
                                String category,
                                String descriptions) {
        Partners partners = new Partners();
        partners.setTittle(tittle);
        partners.setImage(image);
        partners.setLink(link);
        partners.setLanguage(language);
        partners.setCategory(category);
        partners.setDescriptions(descriptions);
        partnersRepository.save(partners);
        return PartnerResponce.builder()
                .id(partners.getId())
                .tittle(partners.getTittle())
                .image(partners.getImage())
                .link(partners.getLink())
                .language(partners.getLanguage())
                .category(partners.getCategory())
                .descriptions(partners.getDescriptions())
                .build();

    }

    public PartnerResponce update(Long id,
                                  String title,
                                  String image,
                                  String link,
                                  Language language,
                                  String category,
                                  String descriptions) {
        Partners partners = partnersRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        partners.setTittle(title);
        partners.setImage(image);
        partners.setLink(link);
        partners.setLanguage(language);
        partners.setCategory(category);
        partners.setDescriptions(descriptions);
        partnersRepository.save(partners);
        return PartnerResponce.builder()
                .id(partners.getId())
                .tittle(partners.getTittle())
                .image(partners.getImage())
                .link(partners.getLink())
                .language(partners.getLanguage())
                .category(partners.getCategory())
                .descriptions(partners.getDescriptions())
                .build();
    }

    public void delete(Long id) {
        Partners partners = partnersRepository.findById(id).orElseThrow(() -> new RuntimeException("Partner not found with ID: " + id));
        partnersRepository.delete(partners);
    }

    public List<PartnerResponce> findAll() {
        List<PartnerResponce> partnerResponces = new ArrayList<>();
        for (Partners partner : partnersRepository.findAll()) {
            PartnerResponce partnerResponce = new PartnerResponce();
            partnerResponce.setTittle(partner.getTittle());
            partnerResponce.setImage(partner.getImage());
            partnerResponce.setLink(partner.getLink());
            partnerResponce.setLanguage(partner.getLanguage());
            partnerResponce.setCategory(partner.getCategory());
            partnerResponce.setDescriptions(partner.getDescriptions());
            partnerResponce.setId(partner.getId());
            partnerResponces.add(partnerResponce);
        }
        return partnerResponces;
    }

}