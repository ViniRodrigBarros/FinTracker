package com.example.fintracker.util;

import com.example.fintracker.filter.dto.request.RequestTransactionDTO;
import com.example.fintracker.filter.dto.response.TransactionResponseDTO;
import com.example.fintracker.filter.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper {

    public Transaction toTransaction(RequestTransactionDTO transactionDTO){
        //Builder pattern
        return Transaction.builder()
                .categoria(transactionDTO.getCategoria())
                .data(transactionDTO.getData())
                .tipo(transactionDTO.getTipo())
                .user_id(transactionDTO.getUser_id())
                .valor(transactionDTO.getValor())
                .build();

    }

    public TransactionResponseDTO toTransactionDTO(Transaction transaction){
        return new TransactionResponseDTO(transaction);}
    public List<TransactionResponseDTO> toTransactionsDTO(List<Transaction> transactionList){
        return transactionList.stream().map(TransactionResponseDTO::new).collect(Collectors.toList());
    }

    public void updateTransactionData(Transaction transaction,RequestTransactionDTO transactionDTO){
        //transaction.setData(transactionDTO.getData());
        transaction.setCategoria(transactionDTO.getCategoria());
        transaction.setUser_id(transactionDTO.getUser_id());
        transaction.setValor(transactionDTO.getValor());
        transaction.setTipo(transactionDTO.getTipo());


    }
}

//https://www.youtube.com/watch?v=VK-RJPl1ALg&t=1881s 35:00