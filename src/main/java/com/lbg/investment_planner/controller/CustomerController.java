package com.lbg.investment_planner.controller;

import com.lbg.investment_planner.model.*;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.lbg.investment_planner.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    CustomerService customerService;

    @GetMapping(value = "/customerList")
    public List<Customer> getCustomers() {
        return customerService.findAll();

    }
    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId) {
        return customerService.findById(customerId);

    }
    @GetMapping("/expenses/{customerId}")
    public ExpensesSavings getExpensesSavings(@PathVariable String customerId) {
        return customerService.findExpenseById(customerId);
    }

    @GetMapping("/age/expenses/{customerId}")
    public List<AgeExpenseData> getExpensesByAge(@PathVariable String customerId) {
        return customerService.findExpenseByAge(customerId);
    }

    @GetMapping("/age/savings/{customerId}")
    public List<AgeExpenseData> getSavingsByAge(@PathVariable String customerId) {
        return customerService.findSavingsByAge(customerId);
    }

    @GetMapping("/income/savings/{customerId}")
    public List<AgeExpenseData> getSavingsByIncome(@PathVariable String customerId) {
        return customerService.findSavingsByIncome(customerId);
    }

    @GetMapping("goal/{customerId}/{goalName}")
    public Goal getGoalSuggestion(@PathVariable String customerId,@PathVariable String goalName) {
        return customerService.findGoalSuggestions(customerId,goalName);
    }
    @GetMapping("goal/{customerId}")
    public List<Goal> getSuggestion(@PathVariable String customerId) {
        return customerService.findSuggestions(customerId);
    }

    @GetMapping("expensesCategory/{customerId}")
    public List<TransactionLogging> getExpensesType(@PathVariable String customerId) {
        return customerService.getExpensesCategory(customerId);
    }
    @GetMapping("expensesCategory/{customerId}/{expenseCategory}")
    public List<TransactionLogging> getExpensesCategoryDetails(@PathVariable String customerId,@PathVariable String expenseCategory) {
        return customerService.getExpensesDetailsOfCategory(customerId,expenseCategory);
    }
}
