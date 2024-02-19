package com.sandeep.assignment.springbootAggregator.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sandeep.assignment.springbootAggregator.model.Transaction;

@FeignClient(name = "backendServer3", url = "http://localhost:8083")
public interface BackendServer3Client {

    @GetMapping("/backendserver3/pending/{accountNumber}")
    List<Transaction> getPendingTransactions(@PathVariable String accountNumber);
}