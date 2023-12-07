package com.example.fintracker.adapter;

import com.example.fintracker.model.Account;
import com.example.fintracker.model.OpenFinanceAPI;
import com.example.fintracker.model.Transaction;
import com.example.fintracker.interfaces.AccountService;
import com.example.fintracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OpenFinanceApiAdapter {

    private final TransactionService transactionService;
    private final AccountService accountService;

    @Autowired
    public OpenFinanceApiAdapter(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    public void synchronizeDataForUser(Long userId) {
        // Obtenha todas as contas do usuário usando o serviço
        List<Account> userAccounts = accountService.getAccountsByUserId(userId);

        // Itere sobre as contas e sincronize os dados para cada uma
        for (Account account : userAccounts) {
            synchronizeDataForAccount(account);
        }
    }

    private void synchronizeDataForAccount(Account account) {
        String apiUrl = "https://openfinance-api-24un.onrender.com/accounts/" + account.getId() + "/transactions";
        RestTemplate restTemplate = new RestTemplate();
        OpenFinanceAPI[] openFinanceData = restTemplate.getForObject(apiUrl, OpenFinanceAPI[].class);

        if (openFinanceData != null) {
            for (OpenFinanceAPI openFinanceTransaction : openFinanceData) {
                Transaction internalTransaction = convertToInternalTransaction(openFinanceTransaction, account);
                transactionService.registerTransaction(
                        internalTransaction.getTipo(),
                        internalTransaction.getValor(),
                        internalTransaction.getUser_id(),
                        internalTransaction.getCategoria(),
                        internalTransaction.getData()
                );
            }
        }
    }

    private Transaction convertToInternalTransaction(OpenFinanceAPI openFinanceTransaction, Account account) {
        Transaction internalTransaction = new Transaction();
        internalTransaction.setUser_id(account.getUser().getId());
        internalTransaction.setValor(Float.parseFloat(openFinanceTransaction.getAmount()));

        // Mapeando a categoria com base no tipo de transação
        if ("Send".equalsIgnoreCase(openFinanceTransaction.getType())) {
            internalTransaction.setCategoria("gasto");
        } else {
            internalTransaction.setCategoria("ganho");
        }

        if ("Credit".equalsIgnoreCase(openFinanceTransaction.getType())) {
            internalTransaction.setTipo("Crédito");
        } else if ("Debit".equalsIgnoreCase(openFinanceTransaction.getType())) {
            internalTransaction.setTipo("Débito");
        } else {
            // Defina um valor padrão ou lógica para outros tipos, se aplicável
            internalTransaction.setTipo("Outro");
        }

        if (openFinanceTransaction.getDate() != null) {
            internalTransaction.setData(parseDate(openFinanceTransaction.getDate()));
        }

        return internalTransaction;
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
