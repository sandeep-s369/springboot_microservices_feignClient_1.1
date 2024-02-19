package com.sandeep.BankTransactions.backendServer2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.BankTransactions.backendServer2.entity.FailureTransaction;

public interface FailureTransactionRepository extends JpaRepository<FailureTransaction, Long> {
    List<FailureTransaction> findByAccountNumber(String accountNumber);
}
