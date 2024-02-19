package com.sandeep.BankTransactions.backendServer2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.BankTransactions.backendServer2.entity.FailureTransaction;
import com.sandeep.BankTransactions.backendServer2.repository.FailureTransactionRepository;

@Service
public class FailureTransactionService {

	@Autowired
	private FailureTransactionRepository failureTransactionRepository;
	
	
	public List<FailureTransaction> findByAccountNumber(String accountNumber){
		return failureTransactionRepository.findByAccountNumber(accountNumber);
	}
	
}
