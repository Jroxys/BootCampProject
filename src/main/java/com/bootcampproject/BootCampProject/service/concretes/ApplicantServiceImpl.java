package com.bootcampproject.BootCampProject.service.concretes;

import com.bootcampproject.BootCampProject.entity.Applicant;
import com.bootcampproject.BootCampProject.entity.Instructor;
import com.bootcampproject.BootCampProject.repository.ApplicantRepository;
import com.bootcampproject.BootCampProject.repository.InstructorRepository;
import com.bootcampproject.BootCampProject.service.abstracts.ApplicantService;
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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository applicantRepository;
    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public CreatedApplicantResponse add(CreateApplicantRequest createApplicantRequest) {
        Applicant applicant = new Applicant();
        applicant.setUsername(createApplicantRequest.getUsername());
        applicant.setFirstName(createApplicantRequest.getFirstName());
       applicant.setLastName(createApplicantRequest.getLastName());
       applicant.setDateOfBirth(createApplicantRequest.getDateOfBirth());
       applicant.setNationalIdentity(createApplicantRequest.getNationalIdentity());
      applicant.setEmail(createApplicantRequest.getEmail());
      applicant.setPassword(createApplicantRequest.getPassword());
      applicant.setAbout(createApplicantRequest.getAbout());

        Applicant savedApplicant = applicantRepository.save(applicant);

        CreatedApplicantResponse response = new CreatedApplicantResponse();
        response.setId(savedApplicant.getId());
        response.setUsername(savedApplicant.getUsername());
        response.setFirstName(savedApplicant.getFirstName());
        response.setLastName(savedApplicant.getLastName());
        response.setEmail(savedApplicant.getEmail());
        response.setAbout(savedApplicant.getAbout());

        return response;
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest updateApplicantRequest) {
        Applicant applicant = applicantRepository.findById(updateApplicantRequest.getId())
                .orElseThrow(() -> new RuntimeException("Applicant error"));

        applicant.setUsername(updateApplicantRequest.getUsername());
        applicant.setFirstName(updateApplicantRequest.getFirstName());
        applicant.setLastName(updateApplicantRequest.getLastName());
        applicant.setDateOfBirth(updateApplicantRequest.getDateOfBirth());
        applicant.setNationalIdentity(updateApplicantRequest.getNationalIdentity());
        applicant.setEmail(updateApplicantRequest.getEmail());
        applicant.setPassword(updateApplicantRequest.getPassword());
        applicant.setAbout(updateApplicantRequest.getAbout());

        Applicant updatedApplicant = applicantRepository.save(applicant);

        UpdateApplicantResponse response = new UpdateApplicantResponse();
        response.setId(updatedApplicant.getId());
        response.setUsername(updatedApplicant.getUsername());
        response.setFirstName(updatedApplicant.getFirstName());
        response.setLastName(updatedApplicant.getLastName());
        response.setEmail(updatedApplicant.getEmail());
        response.setAbout(updatedApplicant.getAbout());

        return response;
    }

    @Override
    public void delete(int id) {
        applicantRepository.deleteById(id);
    }

    @Override
    public GetApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("err"));

        GetApplicantResponse response = new GetApplicantResponse();
        response.setId(applicant.getId());
        response.setUsername(applicant.getUsername());
        response.setFirstName(applicant.getFirstName());
        response.setLastName(applicant.getLastName());
        response.setDateOfBirth(applicant.getDateOfBirth());
        response.setNationalIdentity(applicant.getNationalIdentity());
        response.setEmail(applicant.getEmail());
        response.setAbout(applicant.getAbout());

        return response;
    }

    @Override
    public List<GetAllAplicantResponse> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();

        return applicants.stream()
                .map(instructor -> {
                    GetAllAplicantResponse response = new GetAllAplicantResponse();
                    response.setId(instructor.getId());
                    response.setUsername(instructor.getUsername());
                    response.setFirstName(instructor.getFirstName());
                    response.setLastName(instructor.getLastName());
                    response.setEmail(instructor.getEmail());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
