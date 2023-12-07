package com.example.fintracker.interfaces;


import com.example.fintracker.model.Transaction;

public interface TransactionObserver {
    void update(Transaction transaction);
}