package com.Zorvyn.finance_data_service.service.imp;

import com.Zorvyn.finance_data_service.entities.FinancialRecord;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDate;

public class FinancialRecordSpecification {

    public static Specification<FinancialRecord> hasType(TransactionType type) {
        return (root, query, cb) ->
                type == null ? null : cb.equal(root.get("type"), type);
    }

    public static Specification<FinancialRecord> hasCategory(String category) {
        return (root, query, cb) ->
                category == null ? null : cb.equal(root.get("category"), category);
    }

    public static Specification<FinancialRecord> dateBetween(LocalDate start, LocalDate end) {
        return (root, query, cb) -> {
            if (start == null || end == null) return null;
            return cb.between(root.get("transactionDate"), start, end);
        };
    }
}
