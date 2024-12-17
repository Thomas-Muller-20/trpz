package com.platus.transactional_service.utils.decorator;

import com.platus.transactional_service.web.dto.TransactionRequest;


public class ValidationTransactionDecorator implements TransactionProcessor {

  private final TransactionProcessor wrappedProcessor;

  public ValidationTransactionDecorator(TransactionProcessor processor) {
    this.wrappedProcessor = processor;
  }

  @Override
  public void process(TransactionRequest request) {
    if (request.getAmount() <= 0) {
      throw new IllegalArgumentException("Transaction amount must be greater than 0.");
    }
    wrappedProcessor.process(request);
  }
}
