package com.platus.transactional_service.utils.decorator;

import com.platus.transactional_service.web.dto.TransactionRequest;

public interface TransactionProcessor {
  void process(TransactionRequest request);
}

