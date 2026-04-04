package com.Zorvyn.finance_data_service.entities;

import com.Zorvyn.finance_data_service.enums.Role;
import com.Zorvyn.finance_data_service.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
@Component
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @ToString.Exclude
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime createAt;
    @OneToMany
    @JoinColumn(name = "created_by")
    private List<FinancialRecord> records;
    void setCreatedAt(){
        createAt= LocalDateTime.now();
    }
}
