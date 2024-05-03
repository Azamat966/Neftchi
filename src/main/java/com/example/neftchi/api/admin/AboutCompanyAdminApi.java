package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.AboutResponse;
import com.example.neftchi.service.AboutCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/about/company/admin")
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AboutCompanyAdminApi {
    private final AboutCompanyService aboutCompanyService;

    @PostMapping("/admin/update/description")
    public AboutResponse updateDescription(@RequestParam Long id,
                                           @RequestParam String description) {
        return aboutCompanyService.updateDescriptions(id, description);
    }

    @PostMapping("/admin/update/tittle")
    public AboutResponse updateTittle(@RequestParam Long id,
                                      @RequestParam String tittle) {
        return aboutCompanyService.updateTittle(id, tittle);
    }

    @PostMapping("/admin/update/video")
    public AboutResponse updateVideo(@RequestParam Long id,
                                     @RequestParam String video) {
        return aboutCompanyService.updateVideo(id, video);
    }

    @GetMapping("/admin/menuPage/find")
    public List<AboutResponse> getAll() {
        return aboutCompanyService.findAll();
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        aboutCompanyService.deleteByID(id);
        return "deleted:" + id;
    }

}