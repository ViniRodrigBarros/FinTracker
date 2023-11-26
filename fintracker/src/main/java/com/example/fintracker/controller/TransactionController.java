package com.example.fintracker.controller;

import com.example.fintracker.filter.dto.request.RequestTransactionDTO;
import com.example.fintracker.filter.dto.response.TransactionResponseDTO;
import com.example.fintracker.filter.model.Transaction;
import com.example.fintracker.service.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.fintracker.repository.TransactionRepository;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<TransactionResponseDTO> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(transactionService.findByID(id));
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponseDTO>> findAll(){
        return ResponseEntity.ok().body(transactionService.findAll());
    }

    @PostMapping
    public ResponseEntity<TransactionResponseDTO> register(@RequestBody RequestTransactionDTO transactionDTO, UriComponentsBuilder uriBuilder){

        TransactionResponseDTO transactionResponseDTO = transactionService.register(transactionDTO);

        URI uri = uriBuilder.path("/transaction/{id}").buildAndExpand(transactionResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(transactionResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TransactionResponseDTO> update(@RequestBody RequestTransactionDTO requestTransactionDTO,@PathVariable(name = "id") Long id){

        return ResponseEntity.ok().body(transactionService.update(id,requestTransactionDTO));

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        return  ResponseEntity.ok().body(transactionService.delete(id));
    }


}

