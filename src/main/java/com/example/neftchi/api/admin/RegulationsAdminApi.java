package com.example.neftchi.api.admin;
import com.example.neftchi.dto.response.RegulationsResponce;
import com.example.neftchi.service.RegulationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/regulations/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RegulationsAdminApi {
    private final RegulationsService service;

    @PostMapping("save")
    public RegulationsResponce save(@RequestParam String regulations,
                                    @RequestParam String file_pdf){
        return service.save(regulations,file_pdf);
    }
    @PutMapping("update")
    public RegulationsResponce update(
            @RequestParam Long id,
            @RequestParam String regulations,
            @RequestParam String file_pdf
    ){
        return service.update(id,regulations,file_pdf);
    }
    @DeleteMapping("delete")
    public void deleteById(@RequestParam Long id){
        service.delete(id);
    }
    @GetMapping("find/all")
    public List<RegulationsResponce> findAll(){
        return service.findAll();
    }
}
