package com.Zorvyn.finance_data_service.dto.request;

import com.Zorvyn.finance_data_service.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateRecordRequest {
    private Double amount;
    private TransactionType type;
    private String category;
    private LocalDate date;
    private String notes;
}
