package com.platus.loan_service.model;

import com.platus.loan_service.utils.ActiveState;
import com.platus.loan_service.utils.ClosedState;
import com.platus.loan_service.utils.LoanState;
import com.platus.loan_service.utils.LoanStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private BigDecimal interestRate;
    @Column(nullable = false)
    private BigDecimal remainingAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus status = LoanStatus.ACTIVE;

    public void addInterest(BigDecimal interest) {
        this.remainingAmount = this.remainingAmount.add(interest);
    }
    public void makePayment(BigDecimal payment) {
        this.getState().makePayment(payment, this);
    }
    public void close() {
        this.getState().close(this);
    }
    public void calculateMonthlyInterest() {
        this.getState().calculateInterest(this);
    }
    private LoanState getState(){
        return this.status.equals(LoanStatus.ACTIVE)? new ActiveState(): new ClosedState();
    }
}
