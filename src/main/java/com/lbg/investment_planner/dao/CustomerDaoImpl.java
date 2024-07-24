package com.lbg.investment_planner.dao;

import com.lbg.investment_planner.dao.mapper.CustomerDaoMapper;
import com.lbg.investment_planner.model.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    public CustomerDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<Expenses> getExpensesCategory(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql = "select Category_Sub_Type, sum(spend_percentage) expense_percentage from customer_transaction_logging where customer_id=:customerId and Category_Sub_Type in ('Shopping','Entertainment','Food','Holiday') group by Category_Sub_Type";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Expenses> expensesList = new ArrayList<>();
            while (rs.next()){
                Expenses expenses = new Expenses();
                expenses.setId(String.valueOf(rs.getRow()));
                expenses.setLabel(rs.getString("Category_Sub_Type"));
                expenses.setValue(rs.getString("expense_percentage"));
                expensesList.add(expenses);
               }


            rs.close();
            return  expensesList;
        });
    }


    @Override
    public String findByCustomerId(LoginDto loginDto) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", loginDto.getCustomerId());
        final String sql = "select password from users where customerid=:customerId";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            String output = "Unauthorized";
            String decodedPassword = "";
            while (rs.next()) {
                decodedPassword = new String(java.util.Base64.getDecoder().decode(rs.getString("password")));
                if (loginDto.getPassword().equalsIgnoreCase(decodedPassword)) {
                    output = "Success";
                }
            }
            rs.close();
            return output;
        });
    }

    public Double getExpensesSum(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql =  "select sum(expenseAmount) expenseAmount from customerTransactionLogging where customerId=:customerId and typeOfExpense in ('Shopping','Food','Entertainment','Other')";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            double expenseAmount = 0;
            while (rs.next()){
                expenseAmount = rs.getLong("expenseAmount");
            }
            rs.close();
            return expenseAmount;
        });
    }
    public Double getInvestmentsSum(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql =  "select sum(expenseAmount) expenseAmount from customerTransactionLogging where customerId=:customerId and typeOfExpense not in ('Shopping','Food','Entertainment','Other')";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            double expenseAmount = 0;
            while (rs.next()){
                expenseAmount = rs.getLong("expenseAmount");
            }
            rs.close();
            return expenseAmount;
        });
    }
}
