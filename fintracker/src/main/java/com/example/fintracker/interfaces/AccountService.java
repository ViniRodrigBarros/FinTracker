package com.example.fintracker.interfaces;

import com.example.fintracker.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccountsByUserId(Long userId);

}