package com.Zorvyn.finance_data_service.service;

import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateRecordRequest;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.enums.TransactionType;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordService {
    RecordResponse createRecord(CreateRecordRequest request, String requestedByEmail);

    RecordResponse getRecordById(Long id);

    List<RecordResponse> getAllRecords(
            TransactionType type,
            String category,
            LocalDate startDate,
            LocalDate endDate
    );

    RecordResponse updateRecord(Long id, UpdateRecordRequest request);

    void deleteRecord(Long id, String requestedByEmail);
}
