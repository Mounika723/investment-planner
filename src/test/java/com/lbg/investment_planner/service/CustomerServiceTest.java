package com.lbg.investment_planner.service;

import com.lbg.investment_planner.dao.CustomerDao;
import com.lbg.investment_planner.model.InvestmentSuggestions;
import com.lbg.investment_planner.model.LoginDto;
import com.lbg.investment_planner.model.SubCategoryDetails;
import com.lbg.investment_planner.model.Trends;
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
public class CustomerServiceTest {
    @Mock
    CustomerDao customerDao;
    @InjectMocks
    CustomerService customerService;

    @Test
    void checkAuthentication(){
        LoginDto loginDto = new LoginDto();
        loginDto.setCustomerId("1234");
        loginDto.setPassword("password");
        loginDto.setAuthentication("Success");
        Mockito.when(customerDao.findByCustomerId(Mockito.any())).thenReturn(loginDto);
        Assertions.assertEquals(loginDto.getAuthentication(),customerService.checkAuthentication(loginDto).getAuthentication());
    }
    @Test
    void getDetailsByCategoryTest(){
        List<Trends> trendsList = new ArrayList<>();
        Mockito.when(customerDao.getDetailsByCategory(Mockito.anyString(),Mockito.anyString())).thenReturn(trendsList);
        Assertions.assertNotNull(customerService.getDetailsByCategory("1234","Expense"));
    }
    @Test
    void getOverallTrendsTest(){
        List<Trends> trendsList = new ArrayList<>();
        Mockito.when(customerDao.getOverallTrends(Mockito.anyString(),Mockito.anyString())).thenReturn(trendsList);
        Assertions.assertNotNull(customerService.getOverallTrends("1234","Expense"));
    }
    @Test
    void getOverallTrendsByIncomeTest(){
        List<Trends> trendsList = new ArrayList<>();
        Mockito.when(customerDao.getOverallTrendsByIncome(Mockito.anyString(),Mockito.anyString())).thenReturn(trendsList);
        Assertions.assertNotNull(customerService.getOverallTrendsByIncome("1234","Expense"));
    }
    @Test
    void getDetailsByCategorySubCategoryTest(){
        List<SubCategoryDetails> subCategoryDetailsList = new ArrayList<>();
        Mockito.when(customerDao.getDetailsByCategorySubCategory(Mockito.anyString(),Mockito.anyString(),Mockito.anyString())).thenReturn(subCategoryDetailsList);
        Assertions.assertNotNull(customerService.getDetailsByCategorySubCategory("1234","Expense","Shopping"));
    }
    @Test
    void getOverallTrendsByAgeIncomeTest(){
        List<Trends> trendsList = new ArrayList<>();
        Mockito.when(customerDao.getOverallTrendsByAgeIncome(Mockito.anyString(),Mockito.anyString())).thenReturn(trendsList);
        Assertions.assertNotNull(customerService.getOverallTrendsByAgeIncome("1234","Expense"));
    }
    @Test
    void getSuggestionsByGrowPercentageTest(){
        List<InvestmentSuggestions> investmentSuggestionsList = new ArrayList<>();
        Mockito.when(customerDao.getSuggestionsByGrowPercentage(Mockito.any())).thenReturn(investmentSuggestionsList);
        Assertions.assertNotNull(customerService.getSuggestionsByGrowPercentage(1));
    }
}
