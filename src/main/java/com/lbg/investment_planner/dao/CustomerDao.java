package com.lbg.investment_planner.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.investment_planner.model.SubCategoryDetails;
import com.lbg.investment_planner.model.Trends;
import com.lbg.investment_planner.model.LoginDto;

import java.util.List;

public interface CustomerDao {
       List<Trends> getExpensesCategory(String customerId);

    LoginDto findByCustomerId(LoginDto loginDto);

    List<Trends> getInvestmentsCategory(String customerId);

    List<Trends> getDetailsByCategory(String customerId,String category);

    List<Trends>  getOverallTrends(String customerId,String category);

    List<Trends> getOverallTrendsByIncome(String customerId,String category);

    List<SubCategoryDetails> getDetailsByCategorySubCategory(String customerId, String category, String subCategory);
}
