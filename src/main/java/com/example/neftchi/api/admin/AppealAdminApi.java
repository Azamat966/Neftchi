package com.example.neftchi.api.admin;

import com.example.neftchi.model.Appeal;
import com.example.neftchi.repository.AppealRepository;
import com.example.neftchi.service.AppealService;
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
@RequestMapping("api/v1/appeal/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AppealAdminApi {
    private final AppealRepository appealRepository;
    private final AppealService appealService;


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Upload a file")
    @Transactional
    public String saveAppeal(@RequestParam String description,
                             @RequestParam String email,
                             @RequestParam String lastName,
                             @RequestParam String manyDescription,
                             @RequestParam String numberTel,
                             @RequestParam("file_pdf") MultipartFile file) {
        appealService.saveAppeal(description, email, lastName, manyDescription, numberTel, file);
        return "Saved";
    }


    @GetMapping("/pdf/{id}")
    public ResponseEntity<ByteArrayResource> getPdf(@PathVariable Long id) throws IOException {
        Appeal appeal = appealRepository.findById(id).orElseThrow();
        ByteArrayResource resource = new ByteArrayResource(appeal.getData());
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
