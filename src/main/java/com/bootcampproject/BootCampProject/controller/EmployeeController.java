package com.bootcampproject.BootCampProject.controller;

import com.bootcampproject.BootCampProject.service.abstracts.EmployeeService;
import com.bootcampproject.BootCampProject.service.dtos.requests.Employee.CreateEmployeeRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Employee.UpdateEmployeeRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.CreatedEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.GetAllEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.GetEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.UpdateEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public CreatedEmployeeResponse add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        return employeeService.add(createEmployeeRequest);
    }

    @PutMapping
    public UpdateEmployeeResponse update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }

    @GetMapping("/{id}")
    public GetEmployeeResponse getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @GetMapping
    public List<GetAllEmployeeResponse> getAll() {
        return employeeService.getAll();
    }
}

