package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.CategoryResponse;
import com.example.neftchi.dto.response.MiniPartnersRespons;
import com.example.neftchi.service.CategoryService;
import com.example.neftchi.service.MiniPartnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category/admin")
//@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CategoryAdminApi {
    private final CategoryService service;

    @PostMapping("/admin/save/category")
    public CategoryResponse save(@RequestParam String color,
                                 @RequestParam String category,
                                 @RequestParam int importance_number1) {
        return service.save(color, category, importance_number1);
    }

    @GetMapping("/admin/category/findAll")
    public List<CategoryResponse> getAll() {
        return service.findAll();
    }


    @PutMapping("/admin/category/ubdate/{id}")
    public CategoryResponse update(@RequestParam String color,
                                   @PathVariable Long id,
                                   @RequestParam String category,
                                   @RequestParam String importance_number) {
        return service.update(id, color, category, importance_number);

    }

    @DeleteMapping("/menuPage/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "deleted:" + id;
    }
}