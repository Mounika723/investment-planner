package com.lbg.investment_planner.service;

import com.lbg.investment_planner.dao.CustomerDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    CustomerDao customerDao;
    @InjectMocks
    CustomerService customerService;

    @Test
    void checkAuthentication(){

    }
}
