package com.bootcampproject.BootCampProject.service.concretes;

import com.bootcampproject.BootCampProject.entity.User;
import com.bootcampproject.BootCampProject.repository.UserRepository;
import com.bootcampproject.BootCampProject.service.abstracts.UserService;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.CreateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.requests.User.UpdateUserRequest;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.CreatedUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetAllUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.GetUserResponse;
import com.bootcampproject.BootCampProject.service.dtos.responses.User.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreatedUserResponse add(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setFirstName(createUserRequest.getFirstName());
        user.setLastName(createUserRequest.getLastName());
        user.setDateOfBirth(createUserRequest.getDateOfBirth());
        user.setNationalIdentity(createUserRequest.getNationalIdentity());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());

        User savedUser = userRepository.save(user);

        CreatedUserResponse response = new CreatedUserResponse();
        response.setId(savedUser.getId());
        response.setUsername(savedUser.getUsername());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setEmail(savedUser.getEmail());

        return response;
    }


    @Override
    public UpdateUserResponse update(UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(updateUserRequest.getId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        user.setUsername(updateUserRequest.getUsername());
        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        user.setDateOfBirth(updateUserRequest.getDateOfBirth());
        user.setNationalIdentity(updateUserRequest.getNationalIdentity());
        user.setEmail(updateUserRequest.getEmail());
        user.setPassword(updateUserRequest.getPassword());

        User updatedUser = userRepository.save(user);

        UpdateUserResponse response = new UpdateUserResponse();
        response.setId(updatedUser.getId());
        response.setUsername(updatedUser.getUsername());
        response.setFirstName(updatedUser.getFirstName());
        response.setLastName(updatedUser.getLastName());
        response.setEmail(updatedUser.getEmail());

        return response;
    }


    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setDateOfBirth(user.getDateOfBirth());
        response.setNationalIdentity(user.getNationalIdentity());
        response.setEmail(user.getEmail());

        return response;
    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> {
                    GetAllUserResponse response = new GetAllUserResponse();
                    response.setId(user.getId());
                    response.setUsername(user.getUsername());
                    response.setFirstName(user.getFirstName());
                    response.setLastName(user.getLastName());
                    response.setEmail(user.getEmail());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
