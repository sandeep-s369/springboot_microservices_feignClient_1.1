package com.sandeep.BankTransactions.backendServer1.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.BankTransactions.backendServer1.Repository.SuccessTransactionRepository;
import com.sandeep.BankTransactions.backendServer1.entity.SuccessTransaction;
import com.sandeep.BankTransactions.backendServer1.service.SuccessTransactionsService;

import java.util.List;

@RestController
@RequestMapping("/backendserver1")
public class SuccessTransactionController {

	@Autowired
    private SuccessTransactionsService successTransactionService;


    @GetMapping("/success/{accountNumber}")
    public ResponseEntity<List<SuccessTransaction>> getSuccessTransactions(@PathVariable String accountNumber) {
        List<SuccessTransaction> successTransactions = successTransactionService.findByAccountNumber(accountNumber);
        if (successTransactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(successTransactions);
        }
    }
}

