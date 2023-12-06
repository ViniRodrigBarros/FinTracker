package com.example.fintracker.controller.repository;


import com.example.fintracker.filter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByid(Long id);

    User findByEmail(String email);
}

