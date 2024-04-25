package com.example.neftchi.api.admin;
import com.example.neftchi.dto.response.MiniPartnersRespons;
import com.example.neftchi.service.MiniPartnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/mini/partners/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class MiniPartnersAdminApi {
    private final MiniPartnersService service;
    @PostMapping("/admin/save/miniPartners")
    public MiniPartnersRespons save(@RequestParam String conditions,
                                    @RequestParam String cpdf){
        return service.save(conditions,cpdf);
    }
    @GetMapping("/admin/miniPartners/findAll")
    public List<MiniPartnersRespons> getAll(){
        return service.findAll();
    }
    @PutMapping("/admin/miniPartnesr/ubdate/{id}")
    public MiniPartnersRespons ubdate(@RequestParam String conditions,
                                      @PathVariable Long id){
        return service.ubdate(id,conditions);

    }  @PutMapping("/admin/miniPartnesr/ubdat/{id}")
    public MiniPartnersRespons ubdat(@RequestParam String cpdf,
                                      @PathVariable Long id){
        return service.ubdat(id,cpdf);

    }
    @DeleteMapping("/menuPage/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "deleted:"+id;
    }
}