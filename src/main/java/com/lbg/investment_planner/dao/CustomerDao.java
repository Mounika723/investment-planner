package com.lbg.investment_planner.dao;

import com.lbg.investment_planner.model.Trends;
import com.lbg.investment_planner.model.LoginDto;

import java.util.List;

public interface CustomerDao {
       List<Trends> getExpensesCategory(String customerId);

    String findByCustomerId(LoginDto loginDto);

    List<Trends> getInvestmentsCategory(String customerId);
}
