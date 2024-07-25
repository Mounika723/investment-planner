package com.lbg.investment_planner.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.investment_planner.model.*;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lbg.investment_planner.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    CustomerService customerService;

    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String validation = customerService.checkAuthentication(loginDto);
        return ResponseEntity.ok(validation);
    }

    @GetMapping("expensesCategory/{customerId}")
    public List<Trends> getExpensesType(@PathVariable String customerId) {
        return customerService.getExpensesCategory(customerId);
    }

    @GetMapping("investmentsCategory/{customerId}")
    public List<Trends> getInvestmentsByCategory(@PathVariable String customerId) {
        return customerService.getInvestmentsCategory(customerId);
    }

    @GetMapping("trends/{customerId}/{category}")
    public List<Trends> getDetailsByCategory(@PathVariable String customerId,@PathVariable String category) {
        return customerService.getDetailsByCategory(customerId,category);
    }
    @GetMapping("overallTrendsByAge/{customerId}")
    public List<JsonNode>  getOverallTrendsByAge(@PathVariable String customerId) {
        return customerService.getOverallTrends(customerId);
    }
    @GetMapping("overallTrendsByIncome/{customerId}")
    public List<JsonNode>  getOverallTrendsByIncome(@PathVariable String customerId) {
        return customerService.getOverallTrendsByIncome(customerId);
    }
}
