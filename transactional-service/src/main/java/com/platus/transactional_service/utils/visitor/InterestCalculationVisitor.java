package com.platus.transactional_service.utils.visitor;

import com.platus.transactional_service.models.Account;
import com.platus.transactional_service.models.CreditLoan;
import com.platus.transactional_service.models.FamilyFund;
import com.platus.transactional_service.models.SavingsDeposit;

public class InterestCalculationVisitor implements FinanceVisitor {
  @Override
  public void visit(Account account) {
    if (account.getBalance() < 0) {
      throw new IllegalArgumentException("Баланс рахунку не може бути від'ємним: " + account.getBalance());
    }
    double interest = account.getBalance() * 0.03;
  }

  @Override
  public void visit(SavingsDeposit savingsDeposit) {
    if (savingsDeposit.getDepositAmount() <= 0) {
      throw new IllegalArgumentException("Сума депозиту має бути більшою за 0: " + savingsDeposit.getDepositAmount());
    }
    double interest = savingsDeposit.getDepositAmount() * savingsDeposit.getInterestRate();
  }

  @Override
  public void visit(CreditLoan creditLoan) {
    if (creditLoan.getLoanAmount() <= 0) {
      throw new IllegalArgumentException("Сума кредиту має бути більшою за 0: " + creditLoan.getLoanAmount());
    }
    if (creditLoan.getInterestRate() <= 0) {
      throw new IllegalArgumentException("Процентна ставка по кредиту повинна бути більшою за 0: " + creditLoan.getInterestRate());
    }
    double interest = creditLoan.getLoanAmount() * creditLoan.getInterestRate();
  }

  @Override
  public void visit(FamilyFund familyFund) {
    if (familyFund.getTotalAmount() < 0) {
      throw new IllegalArgumentException("Сума в сімейному фонді не може бути від'ємною: " + familyFund.getTotalAmount());
    }
  }
}

