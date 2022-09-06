package com.example.spring_data_test.repositories;

import com.example.spring_data_test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Используем магию!
    Optional<User> findByUsername(String username);
}

