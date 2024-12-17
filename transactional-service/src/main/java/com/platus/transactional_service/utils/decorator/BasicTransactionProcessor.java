package com.platus.transactional_service.utils.decorator;

import com.platus.transactional_service.web.dto.TransactionRequest;
import org.springframework.stereotype.Component;

@Component
public class BasicTransactionProcessor implements TransactionProcessor {

  @Override
  public void process(TransactionRequest request) {
    System.out.println("Processing transaction: " + request);
  }
}
