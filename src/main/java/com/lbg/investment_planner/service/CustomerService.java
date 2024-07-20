package com.lbg.investment_planner.service;

import com.lbg.investment_planner.dao.CustomerDao;
import com.lbg.investment_planner.entity.AgeExpenseData;
import com.lbg.investment_planner.entity.Customer;
import com.lbg.investment_planner.entity.ExpensesSavings;
import com.lbg.investment_planner.entity.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;
    public List<Customer> findAll() {
       return customerDao.findAll();
    }
    public Customer findById(String id) {
        return customerDao.findById(id);
    }
    public ExpensesSavings findExpenseById(String id){return  customerDao.findExpensesById(id);}
    public List<AgeExpenseData> findExpenseByAge(String id){return customerDao.findExpensesByAge(id);}
    public List<AgeExpenseData> findSavingsByAge(String id){return customerDao.findSavingsByAge(id);}

    public List<AgeExpenseData> findSavingsByIncome(String customerId) {return customerDao.findSavingsByIncome(customerId);    }

    public Goal findGoalSuggestions(String customerId, String goalName) {return customerDao.findGoalSuggestions(customerId,goalName);
    }

    public List<Goal> findSuggestions(String customerId) {return customerDao.findSuggestions(customerId);
    }
}
