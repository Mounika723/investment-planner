package com.lbg.investment_planner.dao;

import com.lbg.investment_planner.model.*;

import java.util.List;

public interface CustomerDao {
       List<Expenses> getExpensesCategory(String customerId);

    String findByCustomerId(LoginDto loginDto);
}
