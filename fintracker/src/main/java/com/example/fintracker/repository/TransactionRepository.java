package com.example.fintracker.repository;

import com.example.fintracker.filter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<User, Long> {

}
