package com.bootcampproject.BootCampProject.service.concretes;

import com.bootcampproject.BootCampProject.entity.Employee;
import com.bootcampproject.BootCampProject.repository.EmployeeRepository;
import com.bootcampproject.BootCampProject.service.abstracts.EmployeeService;
import com.bootcampproject.BootCampProject.service.dtos.requests.Employee.CreateEmployeeRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.Employee.UpdateEmployeeRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.CreatedEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.UpdateEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.GetEmployeeResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.Employee.GetAllEmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public CreatedEmployeeResponse add(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        employee.setUsername(createEmployeeRequest.getUsername());
        employee.setFirstName(createEmployeeRequest.getFirstName());
        employee.setLastName(createEmployeeRequest.getLastName());
        employee.setDateOfBirth(createEmployeeRequest.getDateOfBirth());
        employee.setNationalIdentity(createEmployeeRequest.getNationalIdentity());
        employee.setEmail(createEmployeeRequest.getEmail());
        employee.setPassword(createEmployeeRequest.getPassword());
        employee.setPosition(createEmployeeRequest.getPosition());

        Employee savedEmployee = employeeRepository.save(employee);

        CreatedEmployeeResponse response = new CreatedEmployeeResponse();
        response.setId(savedEmployee.getId());
        response.setUsername(savedEmployee.getUsername());
        response.setFirstName(savedEmployee.getFirstName());
        response.setLastName(savedEmployee.getLastName());
        response.setEmail(savedEmployee.getEmail());
        response.setPosition(savedEmployee.getPosition());

        return response;
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = employeeRepository.findById(updateEmployeeRequest.getId())
                .orElseThrow(() -> new RuntimeException("error"));

        employee.setUsername(updateEmployeeRequest.getUsername());
        employee.setFirstName(updateEmployeeRequest.getFirstName());
        employee.setLastName(updateEmployeeRequest.getLastName());
        employee.setDateOfBirth(updateEmployeeRequest.getDateOfBirth());
        employee.setNationalIdentity(updateEmployeeRequest.getNationalIdentity());
        employee.setEmail(updateEmployeeRequest.getEmail());
        employee.setPassword(updateEmployeeRequest.getPassword());
        employee.setPosition(updateEmployeeRequest.getPosition());

        Employee updatedEmployee = employeeRepository.save(employee);

        UpdateEmployeeResponse response = new UpdateEmployeeResponse();
        response.setId(updatedEmployee.getId());
        response.setUsername(updatedEmployee.getUsername());
        response.setFirstName(updatedEmployee.getFirstName());
        response.setLastName(updatedEmployee.getLastName());
        response.setEmail(updatedEmployee.getEmail());
        response.setPosition(updatedEmployee.getPosition());

        return response;
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public GetEmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("error"));

        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setId(employee.getId());
        response.setUsername(employee.getUsername());
        response.setFirstName(employee.getFirstName());
        response.setLastName(employee.getLastName());
        response.setDateOfBirth(employee.getDateOfBirth());
        response.setNationalIdentity(employee.getNationalIdentity());
        response.setEmail(employee.getEmail());
        response.setPosition(employee.getPosition());

        return response;
    }

    @Override
    public List<GetAllEmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> {
                    GetAllEmployeeResponse response = new GetAllEmployeeResponse();
                    response.setId(employee.getId());
                    response.setUsername(employee.getUsername());
                    response.setFirstName(employee.getFirstName());
                    response.setLastName(employee.getLastName());
                    response.setEmail(employee.getEmail());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
