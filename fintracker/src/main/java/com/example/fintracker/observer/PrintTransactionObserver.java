package com.example.fintracker.observer;

import com.example.fintracker.interfaces.TransactionObserver;
import com.example.fintracker.model.Transaction;


public class PrintTransactionObserver implements TransactionObserver {
    @Override
    public void update(Transaction transaction) {
        System.out.println("Transação realizada: " + transaction);
    }
}