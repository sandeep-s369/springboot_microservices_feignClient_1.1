package com.sandeep.BankTransactions.backendServer1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.BankTransactions.backendServer1.Repository.SuccessTransactionRepository;
import com.sandeep.BankTransactions.backendServer1.entity.SuccessTransaction;

@Service
public class SuccessTransactionsService {

	@Autowired
	private SuccessTransactionRepository successTransactionRepository;
	
	public List<SuccessTransaction> findByAccountNumber(String accountNumber){
		return successTransactionRepository.findByAccountNumber(accountNumber);
	}
	
	
}
