package com.Zorvyn.finance_data_service.service.imp;

import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateRecordRequest;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import com.Zorvyn.finance_data_service.service.FinancialRecordService;

import java.time.LocalDate;
import java.util.List;

public class FinancialRecordServiceImp implements FinancialRecordService {
    @Override
    public RecordResponse createRecord(CreateRecordRequest request, String requestedByEmail) {
        return null;
    }

    @Override
    public RecordResponse getRecordById(Long id) {
        return null;
    }

    @Override
    public List<RecordResponse> getAllRecords(TransactionType type, String category, LocalDate startDate, LocalDate endDate) {
        return List.of();
    }

    @Override
    public RecordResponse updateRecord(Long id, UpdateRecordRequest request, String requestedByEmail) {
        return null;
    }

    @Override
    public void deleteRecord(Long id, String requestedByEmail) {

    }
}
