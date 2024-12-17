package com.platus.transactional_service.utils.decorator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionProcessorConfig {

  @Bean
  public TransactionProcessor transactionProcessor(BasicTransactionProcessor basicProcessor) {
    return new MetadataTransactionDecorator(
        new BalanceCheckTransactionDecorator(
            new ValidationTransactionDecorator(basicProcessor)
        )
    );
  }
}
