package com.bootcampproject.BootCampProject.service.abstracts;

import com.bootcampproject.BootCampProject.entity.Instructor;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.CreateInsturctorRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.UpdateInstructorRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.UpdateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.CreatedInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.GetAllInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.GetInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.UpdateInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetAllUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.UpdateUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorService {
    CreatedInstructorResponse add(CreateInsturctorRequest createInsturctorRequest);
    UpdateInstructorResponse update(UpdateInstructorRequest updateInstructorRequest);
    void delete(int id);
    GetInstructorResponse getById(int id);
    List<GetAllInstructorResponse> getAll();
}
