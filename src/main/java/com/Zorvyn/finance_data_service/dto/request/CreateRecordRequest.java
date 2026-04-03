package com.Zorvyn.finance_data_service.dto.request;

import com.Zorvyn.finance_data_service.enums.Role;
import com.Zorvyn.finance_data_service.enums.Status;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateRecordRequest {
    private Double amount;
    private TransactionType type;
    private String category;
    private LocalDate date;
    private String notes;
}
