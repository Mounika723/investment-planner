package com.lbg.investment_planner.dao.mapper;

import com.lbg.investment_planner.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(Long.parseLong(rs.getString("customerId")));
        customer.setCustomerName(rs.getString("customerName"));
        customer.setCustomerEmail(rs.getString("customerEmail"));

        return customer;
    }
}
