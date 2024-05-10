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

}
