package com.platus.transactional_service.utils.decorator;

import com.platus.transactional_service.web.dto.TransactionRequest;

public class BalanceCheckTransactionDecorator implements TransactionProcessor {

  private final TransactionProcessor wrappedProcessor;

  public BalanceCheckTransactionDecorator(TransactionProcessor processor) {
    this.wrappedProcessor = processor;
  }

  @Override
  public void process(TransactionRequest request) {
    if (request.getAmount() > request.getBalance()) {
      throw new IllegalStateException("Insufficient balance for the transaction.");
    }
    wrappedProcessor.process(request);
  }
}

