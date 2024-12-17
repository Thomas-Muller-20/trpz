package com.platus.transactional_service.web.controller;

import com.platus.transactional_service.utils.visitor.ExcelExportVisitor;
import com.platus.transactional_service.utils.visitor.FinanceVisitor;
import com.platus.transactional_service.utils.visitor.InterestCalculationVisitor;
import com.platus.transactional_service.web.service.impl.FinanceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/processing/transactions/finance")
public class FinanceController {

  private final FinanceService financeService;

  @GetMapping("/calculate-interest")
  public String calculateInterest() {
    financeService.insertTestData();
    FinanceVisitor visitor = new InterestCalculationVisitor();
    financeService.getAllAccounts().forEach(account -> account.accept(visitor));
    financeService.getAllDeposits().forEach(deposit -> deposit.accept(visitor));
    financeService.getAllLoans().forEach(loan -> loan.accept(visitor));
    financeService.getAllFamilyFunds().forEach(fund -> fund.accept(visitor));

    return "Розрахунок завершено.";
  }

  @PostMapping("/export-to-excel")
  public String exportToExcel() {
    financeService.insertTestData();
    FinanceVisitor visitor = new ExcelExportVisitor();
    financeService.getAllAccounts().forEach(account -> account.accept(visitor));
    financeService.getAllDeposits().forEach(deposit -> deposit.accept(visitor));
    financeService.getAllLoans().forEach(loan -> loan.accept(visitor));
    financeService.getAllFamilyFunds().forEach(fund -> fund.accept(visitor));

    return "Експорт завершено.";
  }
}

