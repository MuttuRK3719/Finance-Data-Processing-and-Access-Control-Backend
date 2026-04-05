package com.Zorvyn.finance_data_service.dto.response;

import com.Zorvyn.finance_data_service.enums.Role;
import com.Zorvyn.finance_data_service.enums.Status;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private Status status;
    private LocalDateTime createdAt;

    // Optional: include records
    private List<RecordResponse> records;
}
