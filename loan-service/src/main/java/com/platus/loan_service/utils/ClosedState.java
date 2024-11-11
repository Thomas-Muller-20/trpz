package com.platus.loan_service.utils;

import com.platus.loan_service.model.Loan;

import java.math.BigDecimal;

public class ClosedState implements LoanState {
    @Override
    public void close(Loan loan) {
        throw new IllegalStateException("Loan is already closed");
    }

    @Override
    public void makePayment(BigDecimal payment, Loan loan) {
        throw new IllegalStateException("Cannot make payment on closed loan");
    }

    @Override
    public void calculateInterest(Loan loan) {
        throw new IllegalStateException("Cannot calculate interest for closed loan");
    }
}