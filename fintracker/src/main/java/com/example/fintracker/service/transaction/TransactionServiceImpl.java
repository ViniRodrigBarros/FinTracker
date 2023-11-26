package com.example.fintracker.service.transaction;

import com.example.fintracker.filter.dto.request.RequestTransactionDTO;
import com.example.fintracker.filter.dto.response.TransactionResponseDTO;
import com.example.fintracker.filter.model.Transaction;
import com.example.fintracker.repository.TransactionRepository;
import com.example.fintracker.util.TransactionMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;


    @Override
    public TransactionResponseDTO findByID(Long id) {

         Transaction transaction = returnTransaction(id);
         return new TransactionResponseDTO(transaction);

    }

    @Override
    public List<TransactionResponseDTO> findAll() {
        List<Transaction> transactionList = transactionRepository.findAll();
        return transactionMapper.toTransactionsDTO(transactionList);
    }

    @Override
    public TransactionResponseDTO register(RequestTransactionDTO transactionDTO) {
        Transaction transaction = transactionMapper.toTransaction(transactionDTO);
        return transactionMapper.toTransactionDTO(transactionRepository.save(transaction));

    }

    @Override
    public TransactionResponseDTO update(Long id, RequestTransactionDTO transactionDTO) {
        return null;
    }


    public TransactionResponseDTO update(RequestTransactionDTO transactionDTO, Long id) {
        Transaction transaction = returnTransaction(id);
        transactionMapper.updateTransactionData(transaction,transactionDTO);

        return transactionMapper.toTransactionDTO(transactionRepository.save(transaction));
    }

    public String delete(Long id){
        transactionRepository.deleteById(id);
        return "Transaction id " +id+"deleted";
    }

    private Transaction returnTransaction(Long id){
        return transactionRepository.findById(id).orElseThrow(()-> new RuntimeException("id não esta no banco"));
    }
}
