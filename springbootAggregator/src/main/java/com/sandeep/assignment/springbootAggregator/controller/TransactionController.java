package com.sandeep.assignment.springbootAggregator.controller;

import java.util.List; 


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.assignment.springbootAggregator.model.Transaction;
import com.sandeep.assignment.springbootAggregator.service.TransactionService;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    
    /*
    @GetMapping("/transactions/{accountNumber}")
    public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable String accountNumber) {
        List<Transaction> allTransactions = transactionService.getAllTransactions(accountNumber);

        if (allTransactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allTransactions);
    }
     
    
    */
     @GetMapping("/transactions/{accountNumber}/{status}")
     public ResponseEntity<List<Transaction>> getAllTransactions(@PathVariable String accountNumber,
    		 @PathVariable String status) 
     {
        List<Transaction> allTransactions = transactionService.getAllTransactions(accountNumber,status);

        if (allTransactions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(allTransactions);
     } 
 
     
    
    
    
    
    
    
}