package com.example.fintracker.observer;
import com.example.fintracker.interfaces.TransactionObserver;
import com.example.fintracker.model.Transaction;


import java.util.ArrayList;
import java.util.List;

public class TransactionObservable {

    private List<TransactionObserver> observers = new ArrayList<>();

    public void addObserver(TransactionObserver observer,Transaction transaction) {
        observers.add(observer);
        observer.update(transaction);
    }

    public void removeObserver(TransactionObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Transaction transaction) {
        for (TransactionObserver observer : observers) {
            observer.update(transaction);
        }
    }
}
