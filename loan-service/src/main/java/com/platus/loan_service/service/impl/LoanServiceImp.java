package com.platus.loan_service.service.impl;

import com.platus.loan_service.model.Loan;
import com.platus.loan_service.model.dto.LoanDTO;
import com.platus.loan_service.model.dto.PaymentDTO;
import com.platus.loan_service.service.LoanService;
import com.platus.loan_service.utils.ActiveState;
import com.platus.loan_service.web.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanServiceImp implements LoanService {
    private final LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan createLoan(LoanDTO loanDTO) {
        Loan loan = new Loan();
        loan.setAmount(loanDTO.getAmount());
        loan.setRemainingAmount(loanDTO.getAmount());
        loan.setInterestRate(loanDTO.getInterestRate());
        loan.setStartDate(LocalDate.now());
        loan.setEndDate(LocalDate.now().minusYears(1));
        return loanRepository.save(loan);
    }
    public Loan makePayment(Long loanId, PaymentDTO paymentDTO) {
        Loan loan = this.getLoanById(loanId).get();
        loan.makePayment(paymentDTO.getAmount());
        return loanRepository.save(loan);
    }
    public void calculateMonthlyInterest(Long loanId) {
        Loan loan = this.getLoanById(loanId).get();
        loan.calculateMonthlyInterest();
        loanRepository.save(loan);
    }

    public Loan closeLoan(Long loanId) {
        Loan loan = this.getLoanById(loanId).get();
        loan.close();
        return loanRepository.save(loan);
    }
    public Loan updateLoan(Long id, Loan loanDetails) {
        return loanRepository.findById(id)
                .map(loan -> {
                    loan.setAmount(loanDetails.getAmount());
                    loan.setInterestRate(loanDetails.getInterestRate());
                    loan.setStartDate(loanDetails.getStartDate());
                    loan.setEndDate(loanDetails.getEndDate());
                    return loanRepository.save(loan);
                })
                .orElseThrow(() -> new RuntimeException("Loan not found with id " + id));
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
