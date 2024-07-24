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
    public String checkAuthentication(LoginDto loginDto){return customerDao.findByCustomerId(loginDto);}

    public List<Trends> getInvestmentsCategory(String customerId) {return customerDao.getInvestmentsCategory(customerId);
    }

    public List<JsonNode> getDetailsByCategory(String customerId) {return customerDao.getDetailsByCategory(customerId);
    }
}
