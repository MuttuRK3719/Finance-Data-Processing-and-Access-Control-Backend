package com.Zorvyn.finance_data_service.entities;

import com.Zorvyn.finance_data_service.enums.RecordType;
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
    private RecordType type;
    private String category;
    @Column(name = "transaction_date")
    private LocalDate date;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "created_by",nullable = false)
    private User user;

    @Column(name = "created_at")
    private LocalDateTime created_at;

    public void setCreated_at(){
        created_at= LocalDateTime.now();
    }

}
