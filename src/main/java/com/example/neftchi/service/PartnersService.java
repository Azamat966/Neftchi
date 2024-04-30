package com.example.neftchi.service;

import com.example.neftchi.dto.response.PartnerResponce;
import com.example.neftchi.model.Adminstration;
import com.example.neftchi.model.Partners;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.PartnersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Part;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnersService {
    private final PartnersRepository partnersRepository;

    @Transactional
    public void savePartners(String title, String descriptions,String category,String link, Language language, MultipartFile file) {
        try {
            Partners request = new Partners();
            request.setTittle(title);
            request.setDescriptions(descriptions);
            request.setLanguage(language);
            request.setCategory(category);
            request.setLink(link);
            request.setImage(file.getOriginalFilename());
            request.setData(file.getBytes());
            partnersRepository.save(request);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload PDF file", e);
        }
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