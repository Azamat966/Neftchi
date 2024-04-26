package com.example.neftchi.service;

import com.example.neftchi.dto.response.EmployeResponse;
import com.example.neftchi.dto.response.MiniPartnersRespons;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.MiniPartners;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.AddEmployeeRepository;
import com.example.neftchi.repository.MiniPartnersRepository;
import com.example.neftchi.dto.response.EmployeeResponse;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.AddEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import java.util.ArrayList;
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
    private final AddEmployeeRepository addEmployeeRepository;

    public EmployeeResponse update(Long id,
                                   String name_lastname,
                                   String position,
                                   Language language,
                                   String description) {
        AddEmployee addEmployee = addEmployeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID:" + id));
        addEmployee.setName_lastname(name_lastname);
        addEmployee.setPosition(position);
        addEmployee.setLanguage(language);
        addEmployee.setDescription(description);
        addEmployeeRepository.save(addEmployee);

        return EmployeeResponse.builder()
                .id(addEmployee.getId())
                .name_lastname(addEmployee.getName_lastname())
                .position(addEmployee.getPosition())
                .language(addEmployee.getLanguage())
                .description(addEmployee.getDescription()).
                build();

    }

    public EmployeeResponse findById(Long id) {
        AddEmployee addEmployee = addEmployeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found ID:" + id));
        return EmployeeResponse.builder()
                .id(addEmployee.getId())
                .name_lastname(addEmployee.getName_lastname())
                .position(addEmployee.getPosition())
                .language(addEmployee.getLanguage())
                .description(addEmployee.getDescription())
                .build();
    }

    public List<AddEmployee> getEmployeesByCount(int count) {
        List<AddEmployee> list = new ArrayList<>();
        int a = 0;
        for (AddEmployee addEmployee : addEmployeeRepository.findAll()) {
            if (a == count)
                return list;
            list.add(addEmployee);
            a++;
        }
        return list;
    }

    public List<AddEmployee> employeesrepository(int count) {
        List<AddEmployee> list = new ArrayList<>();
        int a = 0;
        for (AddEmployee addEmployee : addEmployeeRepository.findAllByOrderByNameAsc()) {
            if (a == count)
                return list;
            list.add(addEmployee);
            a++;
        }
        return list;
    }

    public List<AddEmployee> emplrepository(int count) {
        List<AddEmployee> list = new ArrayList<>();
        int a = 0;
        for (AddEmployee addEmployee : addEmployeeRepository.findAllByOrderByNameDesc()) {
            if (a == count)
                return list;
            list.add(addEmployee);
            a++;
        }
        return list;
    }

    public List<AddEmployee> dataDesc(int count) {
        List<AddEmployee> list = new ArrayList<>();
        int a = 0;
        for (AddEmployee addEmployee : addEmployeeRepository.findDataDesc()) {
            if (a == count)
                return list;
            list.add(addEmployee);
            a++;
        }
        return list;
    }

    public List<AddEmployee> dataAsc(int count) {
        List<AddEmployee> list = new ArrayList<>();
        int a = 0;
        for (AddEmployee addEmployee : addEmployeeRepository.findDateAsc()) {
            if (a == count)
                return list;
            list.add(addEmployee);
            a++;
        }
        return list;
    }

}
//public ServiceResponse update(Long id, String tittle, String image, String link) {
//        Services menuPage = serviceRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Menu page not found with ID: " + id));
//
//        menuPage.setTittle(tittle);
//        menuPage.setImage(image);
//        menuPage.setLink(link);
//
//        serviceRepository.save(menuPage);
//
//        return ServiceResponse.builder()
//                .id(menuPage.getId())
//                .tittle(menuPage.getTittle())
//                .image(menuPage.getImage())
//                .link(menuPage.getLink())
//                .build();
//    }