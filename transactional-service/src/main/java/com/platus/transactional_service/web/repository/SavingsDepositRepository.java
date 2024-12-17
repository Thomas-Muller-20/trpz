package com.platus.transactional_service.web.repository;

import com.platus.transactional_service.models.SavingsDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsDepositRepository extends JpaRepository<SavingsDeposit, Long> {
}