package com.bootcampproject.BootCampProject.controller;

import com.bootcampproject.BootCampProject.service.abstracts.InstructorService;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.CreateInsturctorRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Instructor.UpdateInstructorRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.CreatedInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.GetAllInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.GetInstructorResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Instructor.UpdateInstructorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")

public class InstructorController {

    private final InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public CreatedInstructorResponse add(@RequestBody CreateInsturctorRequest createInstructorRequest) {
        return instructorService.add(createInstructorRequest);
    }

    @PutMapping
    public UpdateInstructorResponse update(@RequestBody UpdateInstructorRequest updateInstructorRequest) {
        return instructorService.update(updateInstructorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        instructorService.delete(id);
    }

    @GetMapping("/{id}")
    public GetInstructorResponse getById(@PathVariable int id) {
        return instructorService.getById(id);
    }

    @GetMapping
    public List<GetAllInstructorResponse> getAll() {
        return instructorService.getAll();
    }
}
