package com.lbg.investment_planner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionLogging {
    private long customerId;
    private double expenseAmount;
    private String typeOfExpense;
    private String expenseSubType;
    private Date createdDate;
    private Date updatedDate;
    private double expensePercentage;

}
