package com.lbg.investment_planner.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public List<JsonNode> getDetailsByCategory(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql = "select Category_Sub_Type, spend_percentage  from customer_trends where customer_id=:customerId";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Trends> trendsListExpenses = new ArrayList<>();
            List<Trends> trendsListInvestments = new ArrayList<>();
            List<Trends> trendsListExpediture = new ArrayList<>();
            List<String> expenseCategories = List.of("Shopping","Entertainment","Food","Holiday");
            List<String> investCategories = List.of("Mutual Funds","Equity","SIP","Retirement Plan","Health","Term");
            while (rs.next()){
                if(expenseCategories.contains(rs.getString("Category_Sub_Type"))){
                    Trends trends = new Trends();
                trends.setId(String.valueOf(rs.getRow()));
                trends.setLabel(rs.getString("Category_Sub_Type"));
                trends.setValue(rs.getString("spend_percentage"));
                    trendsListExpenses.add(trends);}
                else if(investCategories.contains(rs.getString("Category_Sub_Type"))){
                    Trends trends1 = new Trends();
                    trends1.setId(String.valueOf(rs.getRow()));
                    trends1.setLabel(rs.getString("Category_Sub_Type"));
                    trends1.setValue(rs.getString("spend_percentage"));
                    trendsListInvestments.add(trends1);
                }
                else {
                    Trends trends2 = new Trends();
                    trends2.setId(String.valueOf(rs.getRow()));
                    trends2.setLabel(rs.getString("Category_Sub_Type"));
                    trends2.setValue(rs.getString("spend_percentage"));
                    trendsListExpediture.add(trends2);
                }
            }
            rs.close();
            List<JsonNode> jsonNodeList= new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();

            JsonNode array = null;
            JsonNode array1 = null;
            JsonNode array2 = null;
            try {
                String list1 = mapper.writeValueAsString(trendsListExpenses);
                String list2 = mapper.writeValueAsString(trendsListInvestments);
                String list3 = mapper.writeValueAsString(trendsListExpediture);
                array = mapper.readTree(list1);
                array1 = mapper.readTree(list2);
                array2 = mapper.readTree(list3);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            JsonNode result = mapper.createObjectNode().set("expenses",array);
            JsonNode resultInvestments = mapper.createObjectNode().set("investments",array1);
            JsonNode resultExpenditure = mapper.createObjectNode().set("expenditure",array2);
            jsonNodeList.add(result);
            jsonNodeList.add(resultInvestments);
            jsonNodeList.add(resultExpenditure);
            return jsonNodeList;
        });
    }
}
