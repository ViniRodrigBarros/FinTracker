package com.example.fintracker.filter.interfaces;


import com.example.fintracker.model.Transaction;

public interface TransactionObserver {
    void update(Transaction transaction);
}