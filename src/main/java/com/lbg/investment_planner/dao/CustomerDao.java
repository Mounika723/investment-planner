package com.lbg.investment_planner.dao;

import com.lbg.investment_planner.model.*;

import java.util.List;

public interface CustomerDao {
    List<Customer> findAll();

    Customer findById(String id);

    ExpensesSavings findExpensesById(String id);

    List<AgeExpenseData> findExpensesByAge(String id);

    List<AgeExpenseData> findSavingsByAge(String id);

    List<AgeExpenseData> findSavingsByIncome(String customerId);

    Goal findGoalSuggestions(String customerId, String goalName);

    List<Goal> findSuggestions(String customerId);

    List<TransactionLogging> getExpensesCategory(String customerId);

    List<TransactionLogging> getExpensesDetailsOfCategory(String customerId, String expenseCategory);
}
