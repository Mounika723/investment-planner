package com.lbg.investment_planner.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private long customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String dob;
}
