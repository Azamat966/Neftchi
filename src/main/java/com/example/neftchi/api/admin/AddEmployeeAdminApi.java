package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.EmployeeResponse;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.service.AddEmployeeService;
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
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/add/employee/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AddEmployeeAdminApi {
    private final AddEmployeeService addEmployeeService;

    @PutMapping("/update")
    public EmployeeResponse update(@RequestParam Long id,
                                   @RequestParam String name_lastname,
                                   @RequestParam String position,
                                   @RequestParam Language language,
                                   @RequestParam String description) {
        return addEmployeeService.update(id, name_lastname, position, language, description);
    }

    @GetMapping("/findById")
    public EmployeeResponse findById(@RequestParam Long id) {
        return addEmployeeService.findById(id);
    }

    @GetMapping("find")
    public List<EmployeeResponse> getEmployees(@RequestParam(name = "count") int count) {
        List<AddEmployee> employees = addEmployeeService.getEmployeesByCount(count);
        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(this::convertToEmployeeResponse)
                .collect(Collectors.toList());
        return employeeResponses;
    }

    @GetMapping("find/desc")
    public List<EmployeeResponse> getEmplRepository(@RequestParam(name = "count") int count) {
        List<AddEmployee> employees = addEmployeeService.employeesrepository(count);
        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(this::convertToEmployeeResponse)
                .collect(Collectors.toList());
        return employeeResponses;
    }

    @GetMapping("find/asc")
    public List<EmployeeResponse> getEmployRepository(@RequestParam(name = "count") int count) {
        List<AddEmployee> employees = addEmployeeService.emplrepository(count);
        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(this::convertToEmployeeResponse)
                .collect(Collectors.toList());
        return employeeResponses;
    }

    @GetMapping("find/date/desc")
    public List<EmployeeResponse> getEmployRepositorys(@RequestParam(name = "count") int count) {
        List<AddEmployee> employees = addEmployeeService.dataDesc(count);
        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(this::convertToEmployeeResponse)
                .collect(Collectors.toList());
        return employeeResponses;
    }

    @GetMapping("find/date/asc")
    public List<EmployeeResponse> getEmployRepositorysda(@RequestParam(name = "count") int count) {
        List<AddEmployee> employees = addEmployeeService.dataAsc(count);
        List<EmployeeResponse> employeeResponses = employees.stream()
                .map(this::convertToEmployeeResponse)
                .collect(Collectors.toList());
        return employeeResponses;
    }

    private EmployeeResponse convertToEmployeeResponse(AddEmployee addEmployee) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(addEmployee.getId());
        response.setName_lastname(addEmployee.getName_lastname() + " " + addEmployee.getName_lastname());
        response.setPosition(addEmployee.getPosition());
        response.setLanguage(addEmployee.getLanguage());
        response.setDescription(addEmployee.getDescription());
        return response;
    }
}
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