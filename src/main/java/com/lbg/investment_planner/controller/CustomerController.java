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
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String validation = customerService.checkAuthentication(loginDto);
        return ResponseEntity.ok(validation);
    }

    @GetMapping("expensesCategory/{customerId}")
    public List<Expenses> getExpensesType(@PathVariable String customerId) {
        return customerService.getExpensesCategory(customerId);
    }
}
