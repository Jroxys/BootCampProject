package com.bootcampproject.BootCampProject.service.concretes;

import com.bootcampproject.BootCampProject.entity.Instructor;
import com.bootcampproject.BootCampProject.repository.InstructorRepository;
import com.bootcampproject.BootCampProject.repository.UserRepository;
import com.bootcampproject.BootCampProject.service.abstracts.InstructorService;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.CreateInsturctorRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.UpdateInstructorRequest;
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

public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public CreatedInstructorResponse add(CreateInsturctorRequest createInstructorRequest) {
        Instructor instructor = new Instructor();
        instructor.setUsername(createInstructorRequest.getUsername());
        instructor.setFirstName(createInstructorRequest.getFirstName());
        instructor.setLastName(createInstructorRequest.getLastName());
        instructor.setDateOfBirth(createInstructorRequest.getDateOfBirth());
        instructor.setNationalIdentity(createInstructorRequest.getNationalIdentity());
        instructor.setEmail(createInstructorRequest.getEmail());
        instructor.setPassword(createInstructorRequest.getPassword());
        instructor.setCompanyName(createInstructorRequest.getCompanyName());

        Instructor savedInstructor = instructorRepository.save(instructor);

        CreatedInstructorResponse response = new CreatedInstructorResponse();
        response.setId(savedInstructor.getId());
        response.setUsername(savedInstructor.getUsername());
        response.setFirstName(savedInstructor.getFirstName());
        response.setLastName(savedInstructor.getLastName());
        response.setEmail(savedInstructor.getEmail());
        response.setCompanyName(savedInstructor.getCompanyName());

        return response;
    }

    @Override
    public UpdateInstructorResponse update(UpdateInstructorRequest updateInstructorRequest) {
        Instructor instructor = instructorRepository.findById(updateInstructorRequest.getId())
                .orElseThrow(() -> new RuntimeException("Eğitmen bulunamadı!"));

        instructor.setUsername(updateInstructorRequest.getUsername());
        instructor.setFirstName(updateInstructorRequest.getFirstName());
        instructor.setLastName(updateInstructorRequest.getLastName());
        instructor.setDateOfBirth(updateInstructorRequest.getDateOfBirth());
        instructor.setNationalIdentity(updateInstructorRequest.getNationalIdentity());
        instructor.setEmail(updateInstructorRequest.getEmail());
        instructor.setPassword(updateInstructorRequest.getPassword());
        instructor.setCompanyName(updateInstructorRequest.getCompanyName());

        Instructor updatedInstructor = instructorRepository.save(instructor);

        UpdateInstructorResponse response = new UpdateInstructorResponse();
        response.setId(updatedInstructor.getId());
        response.setUsername(updatedInstructor.getUsername());
        response.setFirstName(updatedInstructor.getFirstName());
        response.setLastName(updatedInstructor.getLastName());
        response.setEmail(updatedInstructor.getEmail());
        response.setCompanyName(updatedInstructor.getCompanyName());

        return response;
    }

    @Override
    public void delete(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public GetInstructorResponse getById(int id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Eğitmen bulunamadı!"));

        GetInstructorResponse response = new GetInstructorResponse();
        response.setId(instructor.getId());
        response.setUsername(instructor.getUsername());
        response.setFirstName(instructor.getFirstName());
        response.setLastName(instructor.getLastName());
        response.setDateOfBirth(instructor.getDateOfBirth());
        response.setNationalIdentity(instructor.getNationalIdentity());
        response.setEmail(instructor.getEmail());
        response.setCompanyName(instructor.getCompanyName());

        return response;
    }

    @Override
    public List<GetAllInstructorResponse> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();

        return instructors.stream()
                .map(instructor -> {
                    GetAllInstructorResponse response = new GetAllInstructorResponse();
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

