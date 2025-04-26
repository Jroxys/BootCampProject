package com.bootcampproject.BootCampProject.service.abstracts;

import com.bootcampproject.BootCampProject.service.dtos.requests.Applicant.CreateApplicantRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Applicant.UpdateApplicantRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Employee.CreateEmployeeRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Employee.UpdateEmployeeRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.CreatedApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.GetAllAplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.GetApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Applicant.UpdateApplicantResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.CreatedEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.GetAllEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.GetEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.UpdateEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    CreatedEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest);
    UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest);
    void delete(int id);
    GetEmployeeResponse getById(int id);
    List<GetAllEmployeeResponse> getAll();
}
