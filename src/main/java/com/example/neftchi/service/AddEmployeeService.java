package com.example.neftchi.service;

import com.example.neftchi.dto.response.EmployeResponse;
import com.example.neftchi.dto.response.MiniPartnersRespons;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.MiniPartners;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.AddEmployeeRepository;
import com.example.neftchi.repository.MiniPartnersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddEmployeeService {

    private final AddEmployeeRepository addEmployeeRepository;


    public EmployeResponse save(String name_lastname,
                                String position, Language language, String description) {
        AddEmployee addEmployee = new AddEmployee();
        addEmployee.setName_lastname(name_lastname);
        addEmployee.setPosition(position);
        addEmployee.setLanguage(language);
        addEmployee.setDescription(description);
        addEmployee.setLocalDateTime(LocalDateTime.now());
        addEmployeeRepository.save(addEmployee);
        return EmployeResponse.builder()
                .id(addEmployee.getId())
                .name_lastname(addEmployee.getName_lastname())
                .position(addEmployee.getPosition())
                .language(addEmployee.getLanguage())
                .description(addEmployee.getDescription())
                .build();
    }

    public void deleteById(Long id) {
        addEmployeeRepository.deleteById(id);
    }
}
