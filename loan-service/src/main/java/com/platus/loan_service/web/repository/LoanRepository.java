package com.platus.loan_service.web.repository;

import com.platus.loan_service.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
