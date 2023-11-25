package com.example.fintracker.service.transaction;

import com.example.fintracker.filter.dto.request.RequestTransactionDTO;
import com.example.fintracker.filter.dto.response.TransactionResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    TransactionResponseDTO findByID(Long id);

    List<TransactionResponseDTO> findAll();

    TransactionResponseDTO register(RequestTransactionDTO transactionDTO);

    TransactionResponseDTO update(RequestTransactionDTO transactionDTO, Long id);




}
