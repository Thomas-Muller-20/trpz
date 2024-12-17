package com.platus.transactional_service.web.service.impl;

import com.platus.transactional_service.models.Account;
import com.platus.transactional_service.models.CreditLoan;
import com.platus.transactional_service.models.FamilyFund;
import com.platus.transactional_service.models.SavingsDeposit;
import com.platus.transactional_service.web.repository.AccountRepository;
import com.platus.transactional_service.web.repository.CreditLoanRepository;
import com.platus.transactional_service.web.repository.FamilyFundRepository;
import com.platus.transactional_service.web.repository.SavingsDepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {
  private final AccountRepository accountRepository;
  private final SavingsDepositRepository depositRepository;
  private final CreditLoanRepository loanRepository;
  private final FamilyFundRepository fundRepository;

  public FinanceService(AccountRepository accountRepository, SavingsDepositRepository depositRepository,
                        CreditLoanRepository loanRepository, FamilyFundRepository fundRepository) {
    this.accountRepository = accountRepository;
    this.depositRepository = depositRepository;
    this.loanRepository = loanRepository;
    this.fundRepository = fundRepository;
  }

  public List<Account> getAllAccounts() {
    return accountRepository.findAll();
  }

  public List<SavingsDeposit> getAllDeposits() {
    return depositRepository.findAll();
  }

  public List<CreditLoan> getAllLoans() {
    return loanRepository.findAll();
  }

  public List<FamilyFund> getAllFamilyFunds() {
    return fundRepository.findAll();
  }
  public void insertTestData() {
    // Створення і збереження рахунків
    accountRepository.save(new Account(1L,"12345", -5000.0));

    // Створення і збереження депозитів
    depositRepository.save(new SavingsDeposit(1L,5000.0, 0.05));

    // Створення і збереження кредитів
    loanRepository.save(new CreditLoan(1L,10000.0, 0.07));

    // Створення і збереження сімейного фонду
    fundRepository.save(new FamilyFund(1L,10000.0, "1231421"));
  }
}

