package com.example.fintracker.service;

import com.example.fintracker.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccountsByUserId(Long userId);

}