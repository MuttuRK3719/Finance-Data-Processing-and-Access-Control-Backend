package com.Zorvyn.finance_data_service.dto.request;

import com.Zorvyn.finance_data_service.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
