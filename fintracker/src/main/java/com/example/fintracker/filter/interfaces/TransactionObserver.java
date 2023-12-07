package com.example.fintracker.filter.interfaces;

import com.example.fintracker.filter.model.Transaction;

public interface TransactionObserver {
    void update(Transaction transaction);
}