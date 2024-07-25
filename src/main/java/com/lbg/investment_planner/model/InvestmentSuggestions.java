package com.lbg.investment_planner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InvestmentSuggestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String riskCategory;
    private String investmentSuggestions;
}
