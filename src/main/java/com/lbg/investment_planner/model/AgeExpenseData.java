package com.lbg.investment_planner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgeExpenseData {
    private String expenses;
    private String savings;
    private long age;
    private String income;
}
