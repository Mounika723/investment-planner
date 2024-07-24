package com.lbg.investment_planner.dao;

import com.lbg.investment_planner.model.*;
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
    public List<Trends> getExpensesCategory(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql = "select Category_Sub_Type, sum(spend_percentage) expense_percentage from customer_transaction_logging where customer_id=:customerId and Category_Sub_Type in ('Shopping','Entertainment','Food','Holiday') group by Category_Sub_Type";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Trends> trendsList = new ArrayList<>();
            while (rs.next()){
                Trends trends = new Trends();
                trends.setId(String.valueOf(rs.getRow()));
                trends.setLabel(rs.getString("Category_Sub_Type"));
                trends.setValue(rs.getString("expense_percentage"));
                trendsList.add(trends);
               }


            rs.close();
            return trendsList;
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

    @Override
    public List<Trends> getInvestmentsCategory(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql = "select Category_Sub_Type, sum(spend_percentage) expense_percentage from customer_transaction_logging where customer_id=:customerId and Category_Sub_Type in ('MutualFunds','Equity','SIP','RetirementPlan','Health','Term') group by Category_Sub_Type";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Trends> trendsList = new ArrayList<>();
            while (rs.next()){
                Trends trends = new Trends();
                trends.setId(String.valueOf(rs.getRow()));
                trends.setLabel(rs.getString("Category_Sub_Type"));
                trends.setValue(rs.getString("expense_percentage"));
                trendsList.add(trends);
            }
            rs.close();
            return trendsList;
        });
    }
}
