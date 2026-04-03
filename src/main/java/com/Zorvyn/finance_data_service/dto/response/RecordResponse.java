package com.Zorvyn.finance_data_service.dto.response;

import com.Zorvyn.finance_data_service.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class RecordResponse {
    private Long id;
    private Double amount;
    private TransactionType type;
    private String category;
    private LocalDate date;
    private String notes;
    private String createdByName;
}
