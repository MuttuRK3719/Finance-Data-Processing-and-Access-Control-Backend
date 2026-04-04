package com.Zorvyn.finance_data_service;

import com.Zorvyn.finance_data_service.dto.request.CreateUserRequest;
import com.Zorvyn.finance_data_service.dto.response.UserResponse;
import com.Zorvyn.finance_data_service.entities.User;
import com.Zorvyn.finance_data_service.enums.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDTOConversion {

    @Mapping( target = "status", constant= "ACTIVE")
    public User mapRequestUserToUser(CreateUserRequest request);

    public UserResponse mapUserToUserResponse(User user);

}
