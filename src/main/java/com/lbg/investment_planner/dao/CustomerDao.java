package com.lbg.investment_planner.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.investment_planner.model.Trends;
import com.lbg.investment_planner.model.LoginDto;

import java.util.List;

public interface CustomerDao {
       List<Trends> getExpensesCategory(String customerId);

    String findByCustomerId(LoginDto loginDto);

    List<Trends> getInvestmentsCategory(String customerId);

    List<Trends> getDetailsByCategory(String customerId,String category);

    List<JsonNode>  getOverallTrends(String customerId);

    List<JsonNode> getOverallTrendsByIncome(String customerId);
}
