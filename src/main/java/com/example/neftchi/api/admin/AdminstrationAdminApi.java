package com.example.neftchi.api.admin;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/adminstration/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminstrationAdminApi {
}
