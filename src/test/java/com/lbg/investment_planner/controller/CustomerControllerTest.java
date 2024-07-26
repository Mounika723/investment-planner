package com.lbg.investment_planner.controller;

import com.lbg.investment_planner.model.InvestmentSuggestions;
import com.lbg.investment_planner.model.LoginDto;
import com.lbg.investment_planner.model.SubCategoryDetails;
import com.lbg.investment_planner.model.Trends;
import com.lbg.investment_planner.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerController customerController;

    @Test
    void getDetailsByCategoryTest(){
        List<Trends> trendsList = new ArrayList<>();
        Mockito.when(customerService.getDetailsByCategory(Mockito.anyString(),Mockito.anyString())).thenReturn(trendsList);
        Assertions.assertNotNull(customerController.getDetailsByCategory("123456789","Expense"));
    }

    @Test
    void getDetailsByCategorySubCategoryTest(){
        List<SubCategoryDetails> subCategoryDetailsList = new ArrayList<>();
        Mockito.when(customerService.getDetailsByCategorySubCategory(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(subCategoryDetailsList);
        Assertions.assertNotNull(customerController.getDetailsByCategorySubCategory("123456789","Expense","Shopping"));
    }
    @Test
    void getOverallTrendsTest(){
        Assertions.assertNotNull(customerController.getOverallTrends("123456789","Age","Expense"));
    }
    @Test
    void getOverallTrendsSalaryTest(){
        Assertions.assertNotNull(customerController.getOverallTrends("123456789","Salary","Expense"));
    }
    @Test
    void getOverallTrendsExpenditureTest(){
        Assertions.assertNotNull(customerController.getOverallTrends("123456789","Expenditure","Expense"));
    }
    @Test
    void loginTest(){
        LoginDto loginDto = new LoginDto();
        loginDto.setCustomerId("1234");
        loginDto.setPassword("password");
        loginDto.setAuthentication("Success");
        Mockito.when(customerService.checkAuthentication(Mockito.any())).thenReturn(loginDto);
        Assertions.assertEquals(loginDto.getAuthentication(),customerController.login(loginDto).getBody().getAuthentication());
    }
    @Test
    void getSuggestionsByGrowPercentageTest(){
        InvestmentSuggestions investmentSuggestions = new InvestmentSuggestions();
        List<InvestmentSuggestions> investmentSuggestionsList = new ArrayList<>();
        investmentSuggestions.setId("1");
        investmentSuggestions.setRiskCategory("Low");
        investmentSuggestions.setInvestmentSuggestions("Fixed Deposit");
        investmentSuggestionsList.add(investmentSuggestions);
        Mockito.when(customerService.getSuggestionsByGrowPercentage(Mockito.any())).thenReturn(investmentSuggestionsList);
        Assertions.assertEquals(investmentSuggestionsList.getFirst().getInvestmentSuggestions(),customerController.getSuggestionsByGrowPercentage(5).getFirst().getInvestmentSuggestions());
    }
}
