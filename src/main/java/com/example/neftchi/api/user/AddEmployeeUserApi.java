package com.example.neftchi.api.user;

import com.example.neftchi.dto.response.EmployeeResponse;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.MenuPageRepository;
import com.example.neftchi.service.AddEmployeeService;
import com.example.neftchi.service.MenuPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/add/employee/user")
public class AddEmployeeUserApi {
    private final AddEmployeeService addEmployeeService;

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