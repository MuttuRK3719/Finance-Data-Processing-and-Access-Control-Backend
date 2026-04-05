package com.Zorvyn.finance_data_service.service.imp;

import com.Zorvyn.finance_data_service.dtoConversion.UserDTOConversion;
import com.Zorvyn.finance_data_service.dto.request.CreateUserRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateUserRequest;
import com.Zorvyn.finance_data_service.dto.response.UserResponse;
import com.Zorvyn.finance_data_service.entities.User;
import com.Zorvyn.finance_data_service.enums.Status;
import com.Zorvyn.finance_data_service.exceptions.DuplicateUser;
import com.Zorvyn.finance_data_service.exceptions.UserNotFound;
import com.Zorvyn.finance_data_service.repository.UserRepository;
import com.Zorvyn.finance_data_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final UserDTOConversion mapper;
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new DuplicateUser("User already exists");
        User user=mapper.mapRequestUserToUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.mapUserToUserResponse(
                userRepository.save(user));
    }

    @Override
    public UserResponse getUserById(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFound(String.format("No user found with id: %d", id)));
        return mapper.mapUserToUserResponse(existingUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository
                .findAll()
                .stream()
                .map(user -> mapper.mapUserToUserResponse(user))
                .toList();
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest request) {
        findById(id);
        Optional<User> user = userRepository.findById(id);
        User updatedUser = mapper.mapUpdateUserRequestToUser(request, user.get());
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        User responsedUser = userRepository.save(updatedUser);
        return mapper.mapUserToUserResponse(responsedUser);
    }

    @Override
    public void deleteUser(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse updateStatus(Long id, Status status) {
        findById(id);
        Optional<User> user = userRepository.findById(id);
        user.get().setStatus(status);
        userRepository.save(user.get());
        return mapper.mapUserToUserResponse(user.get());
    }

    private void findById(Long id) {

        if (!userRepository.existsById(id))
            throw new UserNotFound(String.format("No such user exists with id : %d", id));
    }

    private void findByEmail(String email){
        if(!userRepository.existsByEmail(email))
            throw new UserNotFound(String.format("No such user exists with email : %s", email));
    }
}
