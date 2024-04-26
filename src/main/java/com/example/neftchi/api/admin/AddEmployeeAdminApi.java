package com.example.neftchi.api.admin;
import com.example.neftchi.dto.response.AboutResponse;
import com.example.neftchi.dto.response.EmployeResponse;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.service.AboutCompanyService;
import com.example.neftchi.service.AddEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/add/employee/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AddEmployeeAdminApi {
    private final AddEmployeeService addEmployeeService;
    @PostMapping("/admin/save/")
    public EmployeResponse updateDescription(@RequestParam String  name_lastname,
                                             @RequestParam  String position,
                                             @RequestParam Language language,
                                             @RequestParam String description) {
        return addEmployeeService.save(name_lastname, position, language, description);
    }
    @DeleteMapping("/save/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        addEmployeeService.deleteById(id);
        return "deleted:" + id;
    }
}