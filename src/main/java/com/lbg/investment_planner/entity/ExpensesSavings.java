package com.lbg.investment_planner.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpensesSavings {
    private long customerId;
    private String expenses;
    private String savings;
    private long age;
    private String income;

}
