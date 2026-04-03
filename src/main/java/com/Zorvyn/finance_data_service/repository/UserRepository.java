package com.Zorvyn.finance_data_service.repository;

import com.Zorvyn.finance_data_service.entities.User;
import com.Zorvyn.finance_data_service.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    List<User> findByStatus(Status status);

    boolean existsByEmail(String email);
}
