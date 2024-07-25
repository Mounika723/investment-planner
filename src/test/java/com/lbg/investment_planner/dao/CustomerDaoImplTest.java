package com.lbg.investment_planner.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@ExtendWith(MockitoExtension.class)
public class CustomerDaoImplTest {
    @Mock
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @InjectMocks
    CustomerDaoImpl customerDao;

    @Test
    void findByCustomerIdTest(){

    }
}
