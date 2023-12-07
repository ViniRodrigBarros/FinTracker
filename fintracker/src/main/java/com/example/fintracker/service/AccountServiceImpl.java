package com.example.fintracker.service;
import com.example.fintracker.model.Account;
import com.example.fintracker.service.AccountService;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Account> getAccountsByUserId(Long userId) {
        // Sua lógica para obter as contas do usuário usando JPQL ou CriteriaQuery
        // Exemplo fictício:
        return entityManager.createQuery("SELECT a FROM Account a WHERE a.user.id = :userId", Account.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    // Implemente outros métodos da interface, se necessário
}