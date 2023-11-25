package com.example.fintracker.service.transaction;

import com.example.fintracker.filter.dto.request.RequestTransactionDTO;
import com.example.fintracker.filter.dto.response.TransactionResponseDTO;
import com.example.fintracker.repository.TransactionRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public TransactionResponseDTO findByID(Long id) {

        return null;
    }

    @Override
    public List<TransactionResponseDTO> findAll() {
        return null;
    }

    @Override
    public TransactionResponseDTO register(RequestTransactionDTO transactionDTO) {
        return null;
    }

    @Override
    public TransactionResponseDTO update(RequestTransactionDTO transactionDTO, Long id) {
        return null;
    }
}
