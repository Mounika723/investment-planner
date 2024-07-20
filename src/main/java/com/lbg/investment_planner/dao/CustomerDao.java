package com.lbg.investment_planner.dao;

import com.lbg.investment_planner.entity.AgeExpenseData;
import com.lbg.investment_planner.entity.Customer;
import com.lbg.investment_planner.entity.ExpensesSavings;
import com.lbg.investment_planner.entity.Goal;
import org.springframework.stereotype.Repository;

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
}
