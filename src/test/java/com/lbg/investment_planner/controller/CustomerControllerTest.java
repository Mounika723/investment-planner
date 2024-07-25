package com.lbg.investment_planner.controller;

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
    void getExpensesTypeTest(){
        List<Trends> trendsList = new ArrayList<>();
        Mockito.when(customerService.getExpensesCategory(Mockito.anyString())).thenReturn(trendsList);
        Assertions.assertNotNull(customerController.getExpensesType("123456789"));
    }

    @Test
    void getInvestmentsByCategoryTest(){
        List<Trends> trendsList = new ArrayList<>();
        Mockito.when(customerService.getInvestmentsCategory(Mockito.anyString())).thenReturn(trendsList);
        Assertions.assertNotNull(customerController.getInvestmentsByCategory("123456789"));
    }
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
        Assertions.assertNotNull(customerController.getOverallTrends("123456789","Expense","Age"));
    }
}
