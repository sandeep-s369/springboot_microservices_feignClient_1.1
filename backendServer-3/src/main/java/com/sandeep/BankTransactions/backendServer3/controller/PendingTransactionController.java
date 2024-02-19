package com.sandeep.BankTransactions.backendServer3.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.BankTransactions.backendServer3.entity.PendingTransaction;
import com.sandeep.BankTransactions.backendServer3.repository.PendingTransactionRepository;
import com.sandeep.BankTransactions.backendServer3.service.PendingTransactionService;

import java.util.List;

@RestController
@RequestMapping("/backendserver3")
public class PendingTransactionController {

	@Autowired
    private PendingTransactionService pendingTransactionService;

 

    @GetMapping("/pending/{accountNumber}")
    public ResponseEntity<List<PendingTransaction>> getPendingTransactions(@PathVariable String accountNumber) {
        List<PendingTransaction> pendingTransactions = pendingTransactionService.findByAccountNumber(accountNumber);
        if (pendingTransactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(pendingTransactions);
        }
    }
}

