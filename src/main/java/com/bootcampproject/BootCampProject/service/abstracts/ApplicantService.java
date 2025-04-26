package com.bootcampproject.BootCampProject.service.abstracts;

import com.bootcampproject.BootCampProject.service.dtos.requests.Applicant.CreateApplicantRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Applicant.UpdateApplicantRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.CreateInsturctorRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.UpdateInstructorRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.CreatedApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.GetAllAplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.GetApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.UpdateApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.CreatedInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.GetAllInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.GetInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.UpdateInstructorResponse;

import java.util.List;

public interface ApplicantService {
    CreatedApplicantResponse add(CreateApplicantRequest createApplicantRequest);
    UpdateApplicantResponse update(UpdateApplicantRequest updateApplicantRequest);
    void delete(int id);
    GetApplicantResponse getById(int id);
    List<GetAllAplicantResponse> getAll();
}
