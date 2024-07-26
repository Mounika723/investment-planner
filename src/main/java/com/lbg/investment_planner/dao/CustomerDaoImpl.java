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
    public LoginDto findByCustomerId(LoginDto loginDto) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", loginDto.getCustomerId());
        final String sql = "select password from users where customerid=:customerId";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            LoginDto response = new LoginDto();
            response.setCustomerId(loginDto.getCustomerId());
            response.setAuthentication("Unauthorized");
            String decodedPassword = "";
            while (rs.next()) {
                decodedPassword = new String(java.util.Base64.getDecoder().decode(rs.getString("password")));
                if (loginDto.getPassword().equalsIgnoreCase(decodedPassword)) {
                    response.setAuthentication("Success");
                }
            }
            rs.close();
            return response;
        });
    }

    @Override
    public List<Trends> getDetailsByCategory(String customerId,String category) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("customerId", customerId).addValue("category",category);
        final String sql = "select Category_Sub_Type, spend_percentage  from customer_trends where customer_id=:customerId and category=:category";
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

            if("Expense".equalsIgnoreCase(category)) {
               return trendsListExpenses;
            } else if("Investment".equalsIgnoreCase(category)) {
               return trendsListInvestments;
            }else {
                return trendsListExpediture;
            }
        });
    }

    @Override
    public List<Trends> getOverallTrends(String customerId,String category) {
        int age = getAgeOfCustomer(customerId);
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("age", age).addValue("category",category);
        final String sql = "select Category_Sub_Type, spend_percentage  from overall_trends where age_range_from<=:age and age_range_to>=:age and category= :category";
        return template.execute(sql,parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Trends> trendsListExpenses = new ArrayList<>();
            List<Trends> trendsListInvestments = new ArrayList<>();
            List<Trends> trendsListExpenditure = new ArrayList<>();
            List<String> expenseCategories = List.of("Shopping","Entertainment","Food","Holiday");
            List<String> investCategories = List.of("Mutual Funds","Equity","SIP","Retirement Plan","Health","Term");
            List<String> expenditureCategories = List.of("Total Income","Expenses","Investment");
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
                } else if(expenditureCategories.contains(rs.getString("Category_Sub_Type"))){
                    Trends trends1 = new Trends();
                    trends1.setId(String.valueOf(rs.getRow()));
                    trends1.setLabel(rs.getString("Category_Sub_Type"));
                    trends1.setValue(rs.getString("spend_percentage"));
                    trendsListExpenditure.add(trends1);
                }
            }
            rs.close();
            if("Expense".equalsIgnoreCase(category)) {
                return trendsListExpenses;
            } else if("Investment".equalsIgnoreCase(category)) {
                return trendsListInvestments;
            } else {
                return trendsListExpenditure;
            }
        });
    }

    @Override
    public List<Trends> getOverallTrendsByIncome(String customerId,String category) {
        double income = getIncomeOfCusomer(customerId);
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("income", income).addValue("category",category);
        final String sql = "select Category_Sub_Type, spend_percentage  from overall_trends where income_range_from<=:income and income_range_to>=:income and category= :category";
        return template.execute(sql,parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Trends> trendsListExpenses = new ArrayList<>();
            List<Trends> trendsListInvestments = new ArrayList<>();
            List<Trends> trendsListExpenditure = new ArrayList<>();
            List<String> expenseCategories = List.of("Shopping","Entertainment","Food","Holiday");
            List<String> investCategories = List.of("Mutual Funds","Equity","SIP","Retirement Plan","Health","Term");
            List<String> expenditureCategories = List.of("Total Income","Expenses","Investment");
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
                } else if(expenditureCategories.contains(rs.getString("Category_Sub_Type"))){
                    Trends trends1 = new Trends();
                    trends1.setId(String.valueOf(rs.getRow()));
                    trends1.setLabel(rs.getString("Category_Sub_Type"));
                    trends1.setValue(rs.getString("spend_percentage"));
                    trendsListExpenditure.add(trends1);
                }
            }
            rs.close();
            if("Expense".equalsIgnoreCase(category)) {
                return trendsListExpenses;
            } else if("Investment".equalsIgnoreCase(category)) {
                return trendsListInvestments;
            } else {
                return trendsListExpenditure;
            }
        });
    }

    @Override
    public List<SubCategoryDetails> getDetailsByCategorySubCategory(String customerId, String category, String subCategory) {
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("customerId", customerId).addValue("category",category).addValue("subCategory",subCategory);
        final String sql = "select category_vendor,amount,created_date from customer_transaction_logging where customer_id =:customerId and category=:category and category_sub_type=:subCategory";
        return template.execute(sql, parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<SubCategoryDetails> subCategoryDetailsList = new ArrayList<>();
            while (rs.next()){
                SubCategoryDetails subCategoryDetails = new SubCategoryDetails();
                subCategoryDetails.setId(String.valueOf(rs.getRow()));
                subCategoryDetails.setCategory_vendor(rs.getString("category_vendor"));
                subCategoryDetails.setAmount(rs.getString("amount"));
                subCategoryDetails.setCreated_date(rs.getString("created_date"));
                subCategoryDetailsList.add(subCategoryDetails);
            }
            rs.close();
            return subCategoryDetailsList;

        });
    }

    @Override
    public List<InvestmentSuggestions> getSuggestionsByGrowPercentage(Integer growPercentage) {
        List<InvestmentSuggestions> investmentSuggestionsList = new ArrayList<>();
        SqlParameterSource parameters = new MapSqlParameterSource("growPercentage", growPercentage);
        final String sql = "select risk_category,investment_suggestion from invest_guide where grow_percentage_from<=:growPercentage and grow_percentage_to>=:growPercentage";
        return template.execute(sql,parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            InvestmentSuggestions investmentSuggestions = new InvestmentSuggestions();
            while (rs.next()){
                investmentSuggestions.setId(String.valueOf(rs.getRow()));
                investmentSuggestions.setRiskCategory(rs.getString("risk_category"));
                investmentSuggestions.setInvestmentSuggestions(rs.getString("investment_suggestion"));
                investmentSuggestionsList.add(investmentSuggestions);
            }
            rs.close();
            return investmentSuggestionsList;
        });
    }

    private Integer getIncomeOfCusomer(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql = "select customer_income  from customer_details where customer_id=:customerId";
        return template.execute(sql,parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            int age = 0;
            while (rs.next()){
                age = rs.getInt(1);
            }
            rs.close();
            return age;
        });
    }

    public int getAgeOfCustomer(String customerId) {
        SqlParameterSource parameters = new MapSqlParameterSource("customerId", customerId);
        final String sql = "select customer_age  from customer_details where customer_id=:customerId";
        return template.execute(sql,parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            int age = 0;
            while (rs.next()){
               age = rs.getInt(1);
            }
            rs.close();
            return age;
        });
    }

    @Override
    public List<Trends> getOverallTrendsByAgeIncome(String customerId,String category) {
        double income = getIncomeOfCusomer(customerId);
        int age = getAgeOfCustomer(customerId);
        SqlParameterSource parameters = new MapSqlParameterSource().addValue("income", income).addValue("category",category).addValue("age",age);
        final String sql = "select Category_Sub_Type, spend_percentage  from overall_trends where income_range_from<=:income and income_range_to>=:income and category= :category and age_range_from<=:age and age_range_to>=:age";
        return template.execute(sql,parameters, ps -> {
            ResultSet rs = ps.executeQuery();
            List<Trends> trendsListExpenses = new ArrayList<>();
            List<Trends> trendsListInvestments = new ArrayList<>();
            List<Trends> trendsListExpenditure = new ArrayList<>();
            List<String> expenseCategories = List.of("Shopping","Entertainment","Food","Holiday");
            List<String> investCategories = List.of("Mutual Funds","Equity","SIP","Retirement Plan","Health","Term");
            List<String> expenditureCategories = List.of("Total Income","Expenses","Investment");
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
                } else if(expenditureCategories.contains(rs.getString("Category_Sub_Type"))){
                    Trends trends1 = new Trends();
                    trends1.setId(String.valueOf(rs.getRow()));
                    trends1.setLabel(rs.getString("Category_Sub_Type"));
                    trends1.setValue(rs.getString("spend_percentage"));
                    trendsListExpenditure.add(trends1);
                }
            }
            rs.close();
            if("Expense".equalsIgnoreCase(category)) {
                return trendsListExpenses;
            } else if("Investment".equalsIgnoreCase(category)) {
                return trendsListInvestments;
            } else {
                return trendsListExpenditure;
            }
        });
    }
}
