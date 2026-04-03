package com.Zorvyn.finance_data_service.repository;

import com.Zorvyn.finance_data_service.entities.FinancialRecord;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository  extends JpaRepository<FinancialRecord,Long> {

    List<FinancialRecord> findByType(TransactionType type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);
}
