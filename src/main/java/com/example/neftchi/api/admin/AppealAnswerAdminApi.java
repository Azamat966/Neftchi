package com.example.neftchi.api.admin;

import com.example.neftchi.dto.response.AppealResponse;
import com.example.neftchi.service.AppealAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/appeal/answer/admin")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AppealAnswerAdminApi {
    private final AppealAnswerService appealAnswerService;
    @GetMapping("admin/find/all/numberSort/")
    public List<AppealResponse>find1(){
        return appealAnswerService.findAllSordNumberTel();
    }
    @GetMapping("admin/find/all/nameSort/")
    public List<AppealResponse>find2(){
        return appealAnswerService.findAllNameSort();
    }
    @GetMapping("admin/find/all/SortEmail/")
    public List<AppealResponse>find3() {
        return appealAnswerService.FindAllSordEmail();
    } @GetMapping("admin/find/all/numberSort/Desc/")
    public List<AppealResponse>find4(){
        return appealAnswerService.findAllSordNumberTeldesc();
    }
    @GetMapping("admin/find/all/nameSort/Desc/")
    public List<AppealResponse>find5(){
        return appealAnswerService.findAllNameSortdesc();
    }
    @GetMapping("admin/find/all/SortEmail/Desc")
    public List<AppealResponse>find6() {
        return appealAnswerService.FindAllSordEmaildesc();
    }
    @GetMapping("find/asc")
    public List<AppealResponse> getAppealRepository(@RequestParam(name = "count") int count) {
        return appealAnswerService.findAll(count);
    }
    @GetMapping("/findById")
    public AppealResponse findById(@RequestParam Long id) {
        return appealAnswerService.findById(id);
    }
    @DeleteMapping("/save/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        appealAnswerService.deleteById(id);
        return "deleted:" + id;
    }
    @PostMapping("/save/appeal/admin")
    public AppealResponse save(@RequestParam String answer,
                               @RequestParam Long id ) {
        return appealAnswerService.save(id,answer);
}
}