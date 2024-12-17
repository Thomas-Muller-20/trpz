package com.platus.transactional_service.utils.visitor;

import com.platus.transactional_service.models.Account;
import com.platus.transactional_service.models.CreditLoan;
import com.platus.transactional_service.models.FamilyFund;
import com.platus.transactional_service.models.SavingsDeposit;

public interface FinanceVisitor {
  void visit(Account account);
  void visit(SavingsDeposit savingsDeposit);
  void visit(CreditLoan creditLoan);
  void visit(FamilyFund familyFund);
}
