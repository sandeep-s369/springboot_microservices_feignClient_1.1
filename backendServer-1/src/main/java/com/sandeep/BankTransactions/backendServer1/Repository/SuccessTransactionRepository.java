package com.sandeep.BankTransactions.backendServer1.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandeep.BankTransactions.backendServer1.entity.SuccessTransaction;

public interface SuccessTransactionRepository extends JpaRepository<SuccessTransaction, Long> {
    List<SuccessTransaction> findByAccountNumber(String accountNumber);
}
