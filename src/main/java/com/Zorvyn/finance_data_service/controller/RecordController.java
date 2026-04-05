package com.Zorvyn.finance_data_service.controller;

import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateRecordRequest;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import com.Zorvyn.finance_data_service.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("financial_record/v1")
@RequiredArgsConstructor
public class RecordController {
    private final FinancialRecordService financialRecordService;
    @PreAuthorize("hasAnyRole('ADMIN','USER','VIEWER')")
    @GetMapping("{id}")
    public ResponseEntity<RecordResponse> getRecordById(@PathVariable Long id) {
        RecordResponse recordResponse = financialRecordService.getRecordById(id);
        return ResponseEntity.ok(recordResponse);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER','VIEWER')")
    @GetMapping("/all")
    public ResponseEntity<List<RecordResponse>> getAllRecords() {
        List<RecordResponse> recordResponses = financialRecordService.getAllRecords();
        return ResponseEntity.ok().body(recordResponses);
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping
    public ResponseEntity<RecordResponse> saveRecord(@RequestBody CreateRecordRequest request, @RequestParam String email) {
        RecordResponse recordResponse = financialRecordService.createRecord(request, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(recordResponse);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PutMapping
    public ResponseEntity<RecordResponse> updateRecord(Long id, @RequestBody UpdateRecordRequest request, String email) {
        RecordResponse recordResponse = financialRecordService.updateRecord(id, request, email);
        return ResponseEntity.ok().body(recordResponse);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam Long id, @RequestParam String email) {
        financialRecordService.deleteRecord(id, email);
        return ResponseEntity.ok().body("Record deleted successfully");
    }
    @PreAuthorize("hasAnyRole('ADMIN','USER','VIEWER')")
    @GetMapping("/addFilters")
    public ResponseEntity<List<RecordResponse>> getFilteredRecords(@RequestParam TransactionType transactionType,
                                                                   @RequestParam String category,
                                                                   @RequestParam LocalDate startDate,
                                                                   @RequestParam LocalDate endDate) {
        List<RecordResponse> recordResponses = financialRecordService.getAllRecords(transactionType, category, startDate, endDate);
        return ResponseEntity.ok().body(recordResponses);
    }
}
