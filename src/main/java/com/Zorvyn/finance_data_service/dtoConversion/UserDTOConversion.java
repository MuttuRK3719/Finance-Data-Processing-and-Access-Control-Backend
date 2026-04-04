package com.Zorvyn.finance_data_service.dtoConversion;

import com.Zorvyn.finance_data_service.dto.request.CreateUserRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateUserRequest;
import com.Zorvyn.finance_data_service.dto.response.UserResponse;
import com.Zorvyn.finance_data_service.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserDTOConversion {

    @Mapping(target = "status", constant = "ACTIVE")
    User mapRequestUserToUser(CreateUserRequest request);

    UserResponse mapUserToUserResponse(User user);

    User mapUpdateUserRequestToUser(UpdateUserRequest request, @MappingTarget User user);

}
