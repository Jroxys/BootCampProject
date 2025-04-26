package com.bootcampproject.BootCampProject.controller;

import com.bootcampproject.BootCampProject.service.abstracts.UserService;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.UpdateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetAllUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.UpdateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllUserResponse> getUsers() {
        return userService.getAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetUserResponse getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedUserResponse add(@RequestBody CreateUserRequest request) {
        return userService.add(request);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdateUserResponse update(@RequestBody UpdateUserRequest request) {
        return userService.update(request);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
