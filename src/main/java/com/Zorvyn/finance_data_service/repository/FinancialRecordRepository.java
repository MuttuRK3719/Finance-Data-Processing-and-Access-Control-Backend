package com.Zorvyn.finance_data_service.repository;

import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.entities.FinancialRecord;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import com.Zorvyn.finance_data_service.service.imp.FinancialRecordSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository  extends JpaRepository<FinancialRecord,Long>, JpaSpecificationExecutor<FinancialRecord> {

    List<FinancialRecord> findByType(TransactionType type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);


}
