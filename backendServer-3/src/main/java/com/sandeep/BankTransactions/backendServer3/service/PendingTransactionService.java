package com.sandeep.BankTransactions.backendServer3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.BankTransactions.backendServer3.entity.PendingTransaction;
import com.sandeep.BankTransactions.backendServer3.repository.PendingTransactionRepository;



@Service
public class PendingTransactionService {

	@Autowired
	private PendingTransactionRepository pendingTransactionRepository;
	
	public List<PendingTransaction> findByAccountNumber(String accountNumber){
		return pendingTransactionRepository.findByAccountNumber(accountNumber);
	}
}
