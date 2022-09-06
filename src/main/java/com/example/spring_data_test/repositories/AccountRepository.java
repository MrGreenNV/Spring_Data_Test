package com.example.spring_data_test.repositories;

import com.example.spring_data_test.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    // Используем магию!
    Account findAccountById(Long id);
}

