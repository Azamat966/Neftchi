package com.example.neftchi.service;

import com.example.neftchi.dto.response.AppealAnswerResponse;
import com.example.neftchi.dto.response.AppealResponse;
import com.example.neftchi.dto.response.EmployeResponse;
import com.example.neftchi.dto.response.ServiceResponse;
import com.example.neftchi.model.AddEmployee;
import com.example.neftchi.model.Appeal;
import com.example.neftchi.model.AppealAnswer;
import com.example.neftchi.model.Services;
import com.example.neftchi.model.enums.Language;
import com.example.neftchi.repository.AppealAnswerRepository;
import com.example.neftchi.repository.AppealRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.bv.number.bound.MaxValidatorForNumber;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppealAnswerService {
    private final AppealAnswerRepository repository;
    private final AppealRepository appealRepository;

    public List<AppealResponse> findAll(int count) {
        int a = 0;
        List<AppealResponse> serviceResponse = new ArrayList<>();
        for (Appeal menuPage : appealRepository.findAll()) {
            if (a == count) {
                return serviceResponse;
            }
            AppealResponse serviceResponse1 = new AppealResponse();
            serviceResponse1.setId(menuPage.getId());
            serviceResponse1.setFile(menuPage.getFile());
            serviceResponse1.setEmail(menuPage.getEmail());
            serviceResponse1.setDescription(menuPage.getDescription());
            serviceResponse1.setName_lastname(menuPage.getName_lastname());
            serviceResponse1.setStatus(menuPage.getStatus().toString());
            serviceResponse1.setNumberTel(menuPage.getNumberTel());
            serviceResponse1.setManyDescription(menuPage.getManyDescription());
            try {
                serviceResponse1.setAnswer(menuPage.getAppealAnswer().getAnswer());
            } catch (RuntimeException e) {
                serviceResponse1.setAnswer(null);
            }
            serviceResponse.add(serviceResponse1);
            a++;
        }
        return serviceResponse;

    }

    public List<AppealResponse> findAllNameSort() {
        return findAll(appealRepository.findAllSordDate());
    }

    public List<AppealResponse> findAllSordNumberTel() {
        return findAll(appealRepository.findAllSordNumberTel());
    }

    public List<AppealResponse> FindAllSordEmail() {
        return findAll(appealRepository.FindAllSordEmail());
    }

    public List<AppealResponse> findAllNameSortdesc() {
        return findAll(appealRepository.findAllSordDatedesc());
    }

    public List<AppealResponse> findAllSordNumberTeldesc() {
        return findAll(appealRepository.findAllSordNumberTeldesc());
    }

    public List<AppealResponse> FindAllSordEmaildesc() {
        return findAll(appealRepository.FindAllSordEmaildesc());
    }


    private List<AppealResponse> findAll(List<Appeal> list) {
        List<AppealResponse> serviceResponse = new ArrayList<>();
        for (Appeal menuPage : list) {
            AppealResponse serviceResponse1 = new AppealResponse();
            try {
                serviceResponse1.setAnswer(menuPage.getAppealAnswer().getAnswer());
            } catch (Exception e) {
                serviceResponse1.setAnswer(null);
            }
            serviceResponse1.setId(menuPage.getId());
            serviceResponse1.setFile(menuPage.getFile());
            serviceResponse1.setEmail(menuPage.getEmail());
            serviceResponse1.setStatus(menuPage.getStatus().toString());
            serviceResponse1.setDescription(menuPage.getDescription());
            serviceResponse1.setName_lastname(menuPage.getName_lastname());
            serviceResponse1.setNumberTel(menuPage.getNumberTel());
            serviceResponse1.setManyDescription(menuPage.getManyDescription());
            serviceResponse1.setId(menuPage.getId());
            try {
                serviceResponse1.setAnswer(menuPage.getAppealAnswer().getAnswer());
            } catch (RuntimeException e) {
                serviceResponse1.setAnswer(null);
            }
            serviceResponse.add(serviceResponse1);

        }
        return serviceResponse;

    }

    public AppealResponse findById(Long id) {
        Appeal menuPage = appealRepository.findById(id).orElseThrow();
        AppealResponse appealResponse = AppealResponse.builder()
                .id(menuPage.getId())
                .email(menuPage.getEmail())
                .file(menuPage.getFile())
                .description(menuPage.getDescription())
                .manyDescription(menuPage.getManyDescription())
                .status(menuPage.getStatus().toString())
                .name_lastname(menuPage.getName_lastname())
                .numberTel(menuPage.getNumberTel())
                .build();
        try {
            appealResponse.setAnswer(menuPage.getAppealAnswer().getAnswer());
        } catch (RuntimeException e) {
            appealResponse.setAnswer(null);
        }
        return appealResponse;
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public AppealResponse save(
            Long id,
            String answer
    ) {
        Appeal addEmployee = appealRepository.findById(id).orElseThrow();
        AppealAnswer appealAnswer = new AppealAnswer();
        appealAnswer.setAnswer(answer);
        appealAnswer.setAppeal(addEmployee);
        repository.save(appealAnswer);
        addEmployee.setAppealAnswer(appealAnswer);
        appealRepository.save(addEmployee);
        return AppealResponse.builder()
                .id(addEmployee.getId())
                .name_lastname(addEmployee.getName_lastname())
                .numberTel(addEmployee.getNumberTel())
                .manyDescription(addEmployee.getManyDescription())
                .email(addEmployee.getDescription())
                .status(addEmployee.getStatus().toString())
                .answer(addEmployee.getAppealAnswer().getAnswer())
                .description(addEmployee.getDescription())
                .build();
    }
//    AppealAnswer
}