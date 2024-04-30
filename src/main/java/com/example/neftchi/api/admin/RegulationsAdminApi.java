package com.example.neftchi.api.admin;
import com.example.neftchi.model.CreateNews;
import com.example.neftchi.model.Regulations;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.CreateNewsRepository;
import com.example.neftchi.repository.RegulationsRepository;
import com.example.neftchi.service.CreateNewsService;
import com.example.neftchi.service.RegulationsService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/regulations/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RegulationsAdminApi {
    private final RegulationsRepository repository;
    private final RegulationsService service;


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Upload a file")
    @Transactional
    public String saveAppeal(@RequestParam String regulation,
                             @RequestParam("file") MultipartFile file) {
        service.saveRegulations(regulation, file);
        return "Saved";
    }


    @GetMapping("/pdf/{id}")
    public ResponseEntity<ByteArrayResource> getPdf(@PathVariable Long id) throws IOException {
        Regulations regulations = repository.findById(id).orElseThrow();
        ByteArrayResource resource = new ByteArrayResource(regulations.getData());
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}



