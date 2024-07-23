package com.lbg.investment_planner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Goal {
    private String minIncome;
    private String maxIncome;
    private String goalName;
    private String suggestions;
}
