package com.platus.transactional_service.web.repository;

import com.platus.transactional_service.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
