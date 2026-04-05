package com.Zorvyn.finance_data_service.dto.response;

import com.Zorvyn.finance_data_service.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class RecordResponse {
    private Long id;
    private Double amount;
    private TransactionType type;
    private String category;
    private LocalDateTime transactionDate;
    private String notes;
    private String createdByName;
}
