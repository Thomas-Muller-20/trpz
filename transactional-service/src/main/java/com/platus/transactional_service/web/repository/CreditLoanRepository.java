package com.platus.transactional_service.web.repository;

import com.platus.transactional_service.models.CreditLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditLoanRepository extends JpaRepository<CreditLoan, Long> {
}
