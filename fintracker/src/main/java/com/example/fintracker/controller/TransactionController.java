package com.example.fintracker.controller;


import com.example.fintracker.adapter.OpenFinanceApiAdapter;
import com.example.fintracker.dto.response.ClassifiedGainsResponse;
import com.example.fintracker.model.Transaction;

import com.example.fintracker.strategy.CategoriaStrategy;
import com.example.fintracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

    private final TransactionService transactionService;
    private final OpenFinanceApiAdapter openFinanceApiAdapter;

    @Autowired
    public TransactionController(TransactionService transactionService, OpenFinanceApiAdapter openFinanceApiAdapter) {
        this.transactionService = transactionService;
        this.openFinanceApiAdapter = openFinanceApiAdapter;
    }
    @GetMapping("/")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<Transaction> registerTransaction(@RequestBody Transaction transaction) {
        Transaction newTransaction = transactionService.registerTransaction(
                transaction.getTipo(),
                transaction.getValor(),
                transaction.getUser_id(),
                transaction.getCategoria(),
                transaction.getData()
        );
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);

    }


    @GetMapping("/byUserId/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionByUserId(@PathVariable int userId) {
        openFinanceApiAdapter.synchronizeDataForUser((long) userId);

        List<Transaction> transactions = transactionService.getAllTransactions();

        List<Transaction> transactionsByUser = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getUser_id() == userId) {
                transactionsByUser.add(transaction);
            }
        }
        return new ResponseEntity<>(transactionsByUser, HttpStatus.OK);
    }

    @GetMapping("/classified-gains/{userId}")
    public ClassifiedGainsResponse getGains(@PathVariable int userId) {
        List<Transaction> transactions = transactionService.getAllTransactions();

        List<Transaction> allTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getUser_id() == userId) {
                allTransactions.add(transaction);
            }
        }
        CategoriaStrategy.SeparatedTransactions separatedTransactions = CategoriaStrategy.separarPorCategoria(allTransactions);

        // Lógica para calcular a soma das perdas
        double sumOfGains = separatedTransactions.getGanhos().stream()
                .mapToDouble(Transaction::getValor)
                .sum();

        return new ClassifiedGainsResponse(separatedTransactions.getGanhos(), sumOfGains);
    }

    @GetMapping("/classified-loses/{userId}")
    public ClassifiedGainsResponse getLoses(@PathVariable int userId) {
        List<Transaction> transactions = transactionService.getAllTransactions();

        List<Transaction> allTransactions = new ArrayList<>();
        for(int i = 0;i<transactions.size();i++){
            if(transactions.get(i).getUser_id() == userId ){
                allTransactions.add(transactions.get(i));
            }
        }
        CategoriaStrategy.SeparatedTransactions separatedTransactions = CategoriaStrategy.separarPorCategoria(allTransactions);

        // Lógica para calcular a soma dos ganhos
        double sumOfGains = separatedTransactions.getGastos().stream()
                .mapToDouble(Transaction::getValor)
                .sum();

        return new ClassifiedGainsResponse(separatedTransactions.getGastos(), sumOfGains);
    }

}
