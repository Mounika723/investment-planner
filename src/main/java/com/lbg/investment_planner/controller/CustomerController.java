package com.lbg.investment_planner.controller;

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

    @GetMapping("trends/{customerId}/{category}")
    public List<Trends> getDetailsByCategory(@PathVariable String customerId,@PathVariable String category) {
        return customerService.getDetailsByCategory(customerId,category);
    }

    @GetMapping("transactions/{customerId}/{category}/{subcategory}")
    public List<SubCategoryDetails> getDetailsByCategorySubCategory(@PathVariable String customerId,@PathVariable String category,@PathVariable String subcategory) {
        return customerService.getDetailsByCategorySubCategory(customerId,category,subcategory);
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
    @GetMapping("investment/{growPercentage}")
    public List<InvestmentSuggestions> getSuggestionsByGrowPercentage(@PathVariable Integer growPercentage) {
        return customerService.getSuggestionsByGrowPercentage(growPercentage);
    }
}
