package com.platus.loan_service.utils;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.platus.loan_service.model.Loan;

import java.math.BigDecimal;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")

public interface LoanState {
    void close(Loan loan);

    void makePayment(BigDecimal payment, Loan loan);

    void calculateInterest(Loan loan);

}
