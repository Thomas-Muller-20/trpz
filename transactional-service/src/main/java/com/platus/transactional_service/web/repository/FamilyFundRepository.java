package com.platus.transactional_service.web.repository;

import com.platus.transactional_service.models.FamilyFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyFundRepository extends JpaRepository<FamilyFund, Long> {
}
