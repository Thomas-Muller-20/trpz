package com.platus.loan_service.service;

import com.platus.loan_service.model.Loan;
import com.platus.loan_service.model.dto.LoanDTO;
import com.platus.loan_service.model.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    List<Loan> getAllLoans();

    Optional<Loan> getLoanById(Long id);

    Loan createLoan(LoanDTO loanDTO);

    Loan updateLoan(Long id, Loan loanDetails);

    void deleteLoan(Long id);

    Loan makePayment(Long id, PaymentDTO paymentDTO);

    Loan closeLoan(Long id);

    void calculateMonthlyInterest(Long id);
}
