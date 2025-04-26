package com.bootcampproject.BootCampProject.service.abstracts;

import com.bootcampproject.BootCampProject.entity.User;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.UpdateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetAllUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.UpdateUserResponse;

import java.util.List;

public interface UserService {
    CreatedUserResponse add(CreateUserRequest createUserRequest);
    UpdateUserResponse update(UpdateUserRequest updateUserRequest);
    void delete(int id);
    GetUserResponse getById(int id);
    List<GetAllUserResponse> getAll();
}
