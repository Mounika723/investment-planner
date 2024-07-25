package com.lbg.investment_planner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginDto {
    private String customerId;
    private String password;
    private String authentication;
}