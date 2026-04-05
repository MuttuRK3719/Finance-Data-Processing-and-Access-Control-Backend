package com.Zorvyn.finance_data_service.entities;

import com.Zorvyn.finance_data_service.enums.RecordType;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "financial_records")
@Getter
@Setter
@Component
@ToString
public class FinancialRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private String category;
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "created_by",nullable = false)
    private User user;

    @PrePersist
    public void setCreated_at(){
        transactionDate= LocalDateTime.now();
    }

}
