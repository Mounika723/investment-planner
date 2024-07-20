package com.lbg.investment_planner.dao;

import com.lbg.investment_planner.dao.mapper.CustomerDaoMapper;
import com.lbg.investment_planner.entity.AgeExpenseData;
import com.lbg.investment_planner.entity.Customer;
import com.lbg.investment_planner.entity.ExpensesSavings;
import com.lbg.investment_planner.entity.Goal;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    public CustomerDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<Customer> findAll() {
        return template.query("select * from customer", new CustomerDaoMapper());
    }

    @Override
    public Customer findById(String id) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", id);
        final String sql = "select * from customer where customerId=:customerId";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            Customer customer = new Customer();
            while (rs.next()){
                customer.setCustomerEmail(rs.getString("customerEmail"));
                customer.setCustomerId(rs.getLong("customerId"));
                customer.setCustomerName(rs.getString("customerName"));
                customer.setCustomerAddress(rs.getString("customerAddress"));
            }
            rs.close();
            return  customer;
        });
    }

    @Override
    public ExpensesSavings findExpensesById(String id) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", id);
        final String sql = "select * from expensessavings where customerId=:customerId";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            ExpensesSavings expensesSavings = new ExpensesSavings();
            while (rs.next()){
                expensesSavings.setExpenses(rs.getString("Expenses"));
                expensesSavings.setCustomerId(rs.getLong("customerId"));
                expensesSavings.setSavings(rs.getString("savings"));
                expensesSavings.setAge(rs.getLong("age"));
                expensesSavings.setIncome(rs.getString("income"));
            }
            rs.close();
            return  expensesSavings;
        });
    }

    @Override
    public List<AgeExpenseData> findExpensesByAge(String id) {
        long customerAge = findExpensesById(id).getAge();
        StringBuilder ages = new StringBuilder("'");
        for (long i = customerAge-2; i<customerAge+4; i++){
            ages.append(i).append("','");
        }
        String ageRange = ages.substring(0,ages.length()-2);

        final String sql = String.format("select expenses,age from expensessavings where age in (%s)",ageRange);
        return template.execute(sql, ps -> {
            ResultSet rs = ps.executeQuery();
            List<AgeExpenseData> ageExpenseDataList = new ArrayList<>();

            while (rs.next()){
                AgeExpenseData ageExpenseData = new AgeExpenseData();
                ageExpenseData.setExpenses(rs.getString("Expenses"));
                ageExpenseData.setAge(rs.getLong("age"));
                ageExpenseDataList.add(ageExpenseData);
            }
            rs.close();
            return  ageExpenseDataList;
        });
    }

    @Override
    public List<AgeExpenseData> findSavingsByAge(String id) {
        long customerAge = findExpensesById(id).getAge();
        StringBuilder ages = new StringBuilder("'");
        for (long i = customerAge-2; i<customerAge+4; i++){
            ages.append(i).append("','");
        }
        String ageRange = ages.substring(0,ages.length()-2);

        final String sql = String.format("select savings,age from expensessavings where age in (%s)",ageRange);
        return template.execute(sql, ps -> {
            ResultSet rs = ps.executeQuery();
            List<AgeExpenseData> ageExpenseDataList = new ArrayList<>();
            while (rs.next()){
                AgeExpenseData ageExpenseData = new AgeExpenseData();
                ageExpenseData.setSavings(rs.getString("savings"));
                ageExpenseData.setAge(rs.getLong("age"));
                ageExpenseDataList.add(ageExpenseData);
            }
            rs.close();
            return  ageExpenseDataList;
        });
    }

    @Override
    public List<AgeExpenseData> findSavingsByIncome(String customerId) {
        String income = findExpensesById(customerId).getIncome();
        SqlParameterSource parameters = new MapSqlParameterSource("income", income);
        final String sql = "select * from expensessavings where income=:income";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<AgeExpenseData> ageExpenseDataList = new ArrayList<>();
            while (rs.next()){
                AgeExpenseData ageExpenseData = new AgeExpenseData();
                ageExpenseData.setExpenses(rs.getString("Expenses"));
                ageExpenseData.setSavings(rs.getString("savings"));
                ageExpenseData.setAge(rs.getLong("age"));
                ageExpenseData.setIncome(rs.getString("income"));
                ageExpenseDataList.add(ageExpenseData);
            }
            rs.close();
            return  ageExpenseDataList;
        });
    }

    @Override
    public Goal findGoalSuggestions(String customerId, String goalName) {
        Double income = Double.valueOf(findExpensesById(customerId).getIncome());
        SqlParameterSource parameters = new MapSqlParameterSource("income", income).addValue("goalName",goalName);
        final String sql = "select * from goal where minIncome<=:income and maxIncome>=:income and goalName=:goalName";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            Goal goal = new Goal();
            while (rs.next()){
                goal.setGoalName(rs.getString("goalName"));
                goal.setSuggestions(rs.getString("suggestions"));
            }
            rs.close();
            return  goal;
        });
    }

    @Override
    public List<Goal> findSuggestions(String customerId) {
        double income = Double.parseDouble(findExpensesById(customerId).getIncome());
        SqlParameterSource parameters = new MapSqlParameterSource("income", income);
        final String sql = "select * from goal where minIncome<=:income and maxIncome>=:income";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Goal> goalList = new ArrayList<>();
            while (rs.next()){
                Goal goal = new Goal();
                goal.setGoalName(rs.getString("goalName"));
                goal.setSuggestions(rs.getString("suggestions"));
                goalList.add(goal);
            }
            rs.close();
            return  goalList;
        });
    }
}
