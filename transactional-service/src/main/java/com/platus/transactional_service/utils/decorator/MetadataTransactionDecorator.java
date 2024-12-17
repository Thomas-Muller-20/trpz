package com.platus.transactional_service.utils.decorator;

import com.platus.transactional_service.web.dto.TransactionRequest;

public class MetadataTransactionDecorator implements TransactionProcessor {

  private final TransactionProcessor wrappedProcessor;

  public MetadataTransactionDecorator(TransactionProcessor processor) {
    this.wrappedProcessor = processor;
  }

  @Override
  public void process(TransactionRequest request) {
    request.setCategory("General");
    wrappedProcessor.process(request);
  }
}

