package com.platus.loan_service.utils;

import com.platus.loan_service.model.Loan;

import java.math.BigDecimal;

public class ActiveState implements LoanState {
    @Override
    public void close(Loan loan) {
        if (loan.getRemainingAmount().compareTo(BigDecimal.ZERO) <= 0) {
            loan.setStatus(LoanStatus.CLOSED);
        } else {
            throw new IllegalStateException("Cannot close loan with remaining amount: "+ loan.getAmount());
        }
    }
    @Override
    public void makePayment(BigDecimal payment, Loan loan) {
        loan.setRemainingAmount(loan.getRemainingAmount().subtract(payment));
    }

    @Override
    public void calculateInterest(Loan loan) {
        double interest = loan.getRemainingAmount().doubleValue() *
                loan.getInterestRate().doubleValue() / 12;
        double roundedInterest = Math.round(interest * 100.0) / 100.0;
        loan.addInterest(BigDecimal.valueOf(roundedInterest));
    }
}