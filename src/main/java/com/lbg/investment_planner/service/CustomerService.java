package com.lbg.investment_planner.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.investment_planner.dao.CustomerDao;
import com.lbg.investment_planner.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Trends> getExpensesCategory(String customerId) {return customerDao.getExpensesCategory(customerId);
    }
    public LoginDto checkAuthentication(LoginDto loginDto){return customerDao.findByCustomerId(loginDto);}

    public List<Trends> getInvestmentsCategory(String customerId) {return customerDao.getInvestmentsCategory(customerId);
    }

    public List<Trends> getDetailsByCategory(String customerId,String category) {
        return customerDao.getDetailsByCategory(customerId,category);
    }

    public List<Trends>  getOverallTrends(String customerId,String category) {return customerDao.getOverallTrends(customerId,category);
    }

    public List<Trends> getOverallTrendsByIncome(String customerId,String category) {return customerDao.getOverallTrendsByIncome(customerId,category);
    }

    public List<SubCategoryDetails> getDetailsByCategorySubCategory(String customerId, String category, String subCategory) {return  customerDao.getDetailsByCategorySubCategory(customerId,category,subCategory);
    }

    public List<Trends> getOverallTrendsByAgeIncome(String customerId,String category) {return customerDao.getOverallTrendsByAgeIncome(customerId,category);
    }

    public InvestmentSuggestions getSuggestionsByGrowPercentage(Integer growPercentage) {return customerDao.getSuggestionsByGrowPercentage(growPercentage);
    }
}
