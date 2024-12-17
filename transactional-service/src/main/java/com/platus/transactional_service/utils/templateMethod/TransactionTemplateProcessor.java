package com.platus.transactional_service.utils.templateMethod;

import com.platus.transactional_service.models.Transaction;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public abstract class TransactionTemplateProcessor {
  public final ResponseEntity<Map<String, Object>> processTransaction(Transaction transaction) {
    validate(transaction);
    preProcess(transaction);
    Map<String, Object> result = process(transaction);
    postProcess(transaction);
    return ResponseEntity.ok(result);
  }

  protected abstract void validate(Transaction transaction);
  protected abstract void preProcess(Transaction transaction);
  protected abstract Map<String, Object> process(Transaction transaction);
  protected abstract void postProcess(Transaction transaction);
}