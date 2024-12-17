package com.platus.transactional_service.models;

import com.platus.transactional_service.utils.visitor.FinanceVisitor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditLoan {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(nullable = false)
  private Long id;

  private double loanAmount;
  private double interestRate;

  public void accept(FinanceVisitor visitor) {
    visitor.visit(this);
  }
}