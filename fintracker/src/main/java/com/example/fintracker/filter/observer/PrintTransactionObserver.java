package com.example.fintracker.filter.observer;

import com.example.fintracker.filter.interfaces.TransactionObserver;
import com.example.fintracker.filter.model.Transaction;

public class PrintTransactionObserver implements TransactionObserver {
    @Override
    public void update(Transaction transaction) {
        System.out.println("Transação realizada: " + transaction);
    }
}