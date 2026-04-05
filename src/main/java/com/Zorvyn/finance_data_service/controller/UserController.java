package com.Zorvyn.finance_data_service.controller;

import com.Zorvyn.finance_data_service.dto.request.CreateUserRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateUserRequest;
import com.Zorvyn.finance_data_service.dto.response.UserResponse;
import com.Zorvyn.finance_data_service.enums.Status;
import com.Zorvyn.finance_data_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("user/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id) {
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>> getAllUser() {
        List<UserResponse> userResponses = userService.getAllUsers();
        return ResponseEntity.ok(userResponses);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserResponse userResponse = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        UserResponse userResponse = userService.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }
    @PutMapping("update/status")
    public ResponseEntity<UserResponse>updateUserStatus(@RequestParam Long id, @RequestParam Status status){
        UserResponse userResponse=userService.updateStatus(id,status);
        return  ResponseEntity.ok(userResponse);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
       return ResponseEntity.ok("User deleted successfully");
    }

}
