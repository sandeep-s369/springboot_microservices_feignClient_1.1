package com.sandeep.assignment.springbootAggregator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sandeep.assignment.springbootAggregator.model.Transaction;
import com.sandeep.assignment.springbootAggregator.service.feign.BackendServer1Client;
import com.sandeep.assignment.springbootAggregator.service.feign.BackendServer2Client;
import com.sandeep.assignment.springbootAggregator.service.feign.BackendServer3Client;

@Service
public class TransactionService {

	private final BackendServer1Client backendServer1Client;
	private final BackendServer2Client backendServer2Client;
	private final BackendServer3Client backendServer3Client;

	public TransactionService(BackendServer1Client backendServer1Client, BackendServer2Client backendServer2Client,
			BackendServer3Client backendServer3Client) {
		this.backendServer1Client = backendServer1Client;
		this.backendServer2Client = backendServer2Client;
		this.backendServer3Client = backendServer3Client;
	}

	public List<Transaction> getAllTransactions(String accountNumber, String statusMessage) {
		List<Transaction> allTransactions = new ArrayList<>();

		switch (statusMessage.toLowerCase()) {
		case "pending":
			allTransactions.addAll(backendServer3Client.getPendingTransactions(accountNumber));
			break;
		case "failure":
			allTransactions.addAll(backendServer2Client.getFailureTransactions(accountNumber));
			break;
		case "success":
			allTransactions.addAll(backendServer1Client.getSuccessTransactions(accountNumber));
			break;
		default:
			allTransactions.addAll(backendServer1Client.getSuccessTransactions(accountNumber));
			allTransactions.addAll(backendServer2Client.getFailureTransactions(accountNumber));
			allTransactions.addAll(backendServer3Client.getPendingTransactions(accountNumber));
			break;
		}

		System.out.println(allTransactions);
		return allTransactions;
	}

//	public List<Transaction> getAllTransactions(String accountNumber, String statusMessage) {
//		List<Transaction> allTransactions = new ArrayList<>();
//		String status = statusMessage;
//		if (status.equalsIgnoreCase("pending")) {
//			allTransactions.addAll(backendServer3Client.getPendingTransactions(accountNumber));
//		} else if (status.equalsIgnoreCase("failure")) {
//			allTransactions.addAll(backendServer2Client.getFailureTransactions(accountNumber));
//		} else if (status.equalsIgnoreCase("success")) {
//			allTransactions.addAll(backendServer1Client.getSuccessTransactions(accountNumber));
//		} else {
//			allTransactions.addAll(backendServer1Client.getSuccessTransactions(accountNumber));
//			allTransactions.addAll(backendServer2Client.getFailureTransactions(accountNumber));
//			allTransactions.addAll(backendServer3Client.getPendingTransactions(accountNumber));
//
//		}
//		System.out.println(allTransactions);
//		return allTransactions;
//	}

}