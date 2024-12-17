package com.platus.transactional_service.utils.templateMethod;

import com.platus.transactional_service.models.Transaction;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ExpenseTransactionProcessor extends TransactionTemplateProcessor {
  @Override
  protected void validate(Transaction transaction) {
    if (transaction.getAmount() >= 0) {
      throw new IllegalArgumentException("Expense amount must be negative");
    }
    if (!"EXPENSE".equals(transaction.getType())) {
      throw new IllegalArgumentException("Invalid transaction type for expense");
    }
  }

  @Override
  protected void preProcess(Transaction transaction) {
    transaction.setDate(LocalDate.now());
  }

  @Override
  protected Map<String, Object> process(Transaction transaction) {
    Map<String, Object> result = new HashMap<>();
    result.put("status", "EXPENSE_PROCESSED");
    result.put("amount", transaction.getAmount());
    result.put("description", transaction.getDescription());
    return result;
  }

  @Override
  protected void postProcess(Transaction transaction) {
    // Можливо контроль бюджету або додаткова логіка обробки витрат
  }
}