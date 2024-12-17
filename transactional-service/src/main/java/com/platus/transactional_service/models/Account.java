package com.platus.transactional_service.models;

import com.platus.transactional_service.utils.visitor.FinanceVisitor;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(nullable = false)
  private Long id;

  private String accountNumber;
  private double balance;

  public void accept(FinanceVisitor visitor) {
    visitor.visit(this);
  }
}