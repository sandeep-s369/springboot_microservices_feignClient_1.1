package com.sandeep.BankTransactions.backendServer2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.BankTransactions.backendServer2.entity.FailureTransaction;
import com.sandeep.BankTransactions.backendServer2.repository.FailureTransactionRepository;
import com.sandeep.BankTransactions.backendServer2.service.FailureTransactionService;

import java.util.List;

@RestController
@RequestMapping("/backendserver2")
public class FailureTransactionController {

	@Autowired
    private FailureTransactionService failureTransactionService;

    @GetMapping("/failure/{accountNumber}")
    public ResponseEntity<List<FailureTransaction>> getFailureTransactions(@PathVariable String accountNumber) {
        List<FailureTransaction> failureTransactions = failureTransactionService.findByAccountNumber(accountNumber);
        if (failureTransactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(failureTransactions);
        }
    }
}
