package com.example.neftchi.api.admin;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/image/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class ImageAdminApi {
}
