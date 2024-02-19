package com.sandeep.assignment.springbootAggregator.service.feign;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sandeep.assignment.springbootAggregator.model.Transaction;

@FeignClient(name = "backendServer1", url = "http://localhost:8081")
public interface BackendServer1Client {

    @GetMapping("/backendserver1/success/{accountNumber}")
    List<Transaction> getSuccessTransactions(@PathVariable String accountNumber);
}