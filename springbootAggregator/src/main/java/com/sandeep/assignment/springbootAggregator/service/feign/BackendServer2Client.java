package com.sandeep.assignment.springbootAggregator.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sandeep.assignment.springbootAggregator.model.Transaction;

@FeignClient(name = "backendServer2", url = "http://localhost:8082")
public interface BackendServer2Client {

    @GetMapping("/backendserver2/failure/{accountNumber}")
    List<Transaction> getFailureTransactions(@PathVariable String accountNumber);
}