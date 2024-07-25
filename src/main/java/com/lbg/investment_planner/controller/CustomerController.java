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
    public ResponseEntity<LoginDto> login(@RequestBody LoginDto loginDto){
        LoginDto validation = customerService.checkAuthentication(loginDto);
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

    @GetMapping("transactions/{customerId}/{category}/{subcategory}")
    public List<SubCategoryDetails> getDetailsByCategorySubCategory(@PathVariable String customerId,@PathVariable String category,@PathVariable String subCategory) {
        return customerService.getDetailsByCategorySubCategory(customerId,category,subCategory);
    }

    @GetMapping("overallTrends/{customerId}/{type}/{category}")
    public List<Trends>  getOverallTrends(@PathVariable String customerId,@PathVariable String type,@PathVariable String category) {
        if("Age".equalsIgnoreCase(type)) {
            return customerService.getOverallTrends(customerId,category);
        } else if ("Salary".equalsIgnoreCase(type)){
            return customerService.getOverallTrendsByIncome(customerId,category);
        } else {
            return customerService.getOverallTrendsByAgeIncome(customerId,category);
        }
    }
}
