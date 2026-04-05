package com.Zorvyn.finance_data_service.repository;

import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.entities.FinancialRecord;
import com.Zorvyn.finance_data_service.enums.RecordType;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import com.Zorvyn.finance_data_service.service.imp.FinancialRecordSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface FinancialRecordRepository  extends JpaRepository<FinancialRecord,Long>, JpaSpecificationExecutor<FinancialRecord> {

    List<FinancialRecord> findByType(TransactionType type);

    List<FinancialRecord> findByCategory(String category);

    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT SUM(amount) FROM FinancialRecord where type=:transactionType")
    BigDecimal sumByTransactionType(@Param("transactionType") RecordType transactionType);

    @Query("SELECT category,SUM(amount) FROM FinancialRecord " +
            "GROUP BY category ")
    List<Object[]> groupByCategoryRaw();

    List<FinancialRecord> findByDateAfter(LocalDate date);

}
