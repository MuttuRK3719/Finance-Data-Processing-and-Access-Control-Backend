package com.Zorvyn.finance_data_service.service.imp;

import com.Zorvyn.finance_data_service.UserDTOConversion;
import com.Zorvyn.finance_data_service.dto.request.CreateUserRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateUserRequest;
import com.Zorvyn.finance_data_service.dto.response.UserResponse;
import com.Zorvyn.finance_data_service.entities.User;
import com.Zorvyn.finance_data_service.enums.Status;
import com.Zorvyn.finance_data_service.exceptions.DuplicateUser;
import com.Zorvyn.finance_data_service.exceptions.UserNotFound;
import com.Zorvyn.finance_data_service.repository.UserRepository;
import com.Zorvyn.finance_data_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDTOConversion mapper;
    @Override
    public UserResponse createUser(CreateUserRequest request) {
        if(userRepository.existsByEmail(request.getEmail()))
            throw new DuplicateUser("User already exists");

        return mapper.mapUserToUserResponse(
                userRepository.save(mapper.mapRequestUserToUser(request)));
    }

    @Override
    public UserResponse getUserById(Long id) {
        if(!userRepository.existsById(id))
            throw new UserNotFound(String.format("No such user exists with id : %d",id));
        Optional<User> user=userRepository.findById(id);
        return mapper.mapUserToUserResponse(user.get());
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository
                .findAll()
                .stream()
                .map(user->mapper.mapUserToUserResponse(user))
                .toList();
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        if(!userRepository.existsById(id))
            throw new UserNotFound(String.format("No such user exists with id : %d",id));
        Optional<User>user=userRepository.findById(id);
        User updatedUser=mapper.mapUpdateUserRequestToUser(request,user.get());
        User responsedUser=userRepository.save(updatedUser);
        return mapper.mapUserToUserResponse(responsedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if(!userRepository.existsById(id))
            throw new UserNotFound(String.format("No such user exists with id : %d",id));

        userRepository.deleteById(id);
    }

    @Override
    public UserResponse updateStatus(Long id, Status status) {
        if(!userRepository.existsById(id))
            throw new UserNotFound(String.format("No such user exists with id : %d",id));
        Optional<User> user=userRepository.findById(id);
        user.get().setStatus(status);
        userRepository.save(user.get());
        return mapper.mapUserToUserResponse(user.get());
    }
}
