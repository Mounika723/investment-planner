package com.lbg.investment_planner.model;

import lombok.Data;

@Data
public class LoginDto {
    private String customerId;
    private String password;
}