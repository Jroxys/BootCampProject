package com.bootcampproject.BootCampProject.controller;

import com.bootcampproject.BootCampProject.service.abstracts.ApplicantService;
import com.bootcampproject.BootCampProject.service.dtos.requests.Applicant.CreateApplicantRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Applicant.UpdateApplicantRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.CreatedApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.GetAllAplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.GetApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.UpdateApplicantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")

public class ApplicantController {

    private final ApplicantService applicantService;
    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public CreatedApplicantResponse add(@RequestBody CreateApplicantRequest createApplicantRequest) {
        return applicantService.add(createApplicantRequest);
    }

    @PutMapping
    public UpdateApplicantResponse update(@RequestBody UpdateApplicantRequest updateApplicantRequest) {
        return applicantService.update(updateApplicantRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        applicantService.delete(id);
    }

    @GetMapping("/{id}")
    public GetApplicantResponse getById(@PathVariable int id) {
        return applicantService.getById(id);
    }

    @GetMapping
    public List<GetAllAplicantResponse> getAll() {
        return applicantService.getAll();
    }
}
