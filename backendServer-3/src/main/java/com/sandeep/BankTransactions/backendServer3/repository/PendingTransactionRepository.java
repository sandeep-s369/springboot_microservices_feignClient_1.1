package com.sandeep.BankTransactions.backendServer3.repository;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.BankTransactions.backendServer3.entity.PendingTransaction;

public interface PendingTransactionRepository extends JpaRepository<PendingTransaction, Long> {
    List<PendingTransaction> findByAccountNumber(String accountNumber);
}
