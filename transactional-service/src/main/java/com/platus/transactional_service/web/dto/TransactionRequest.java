package com.platus.transactional_service.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
  private double amount;
  private double balance;
  private String category;
}
