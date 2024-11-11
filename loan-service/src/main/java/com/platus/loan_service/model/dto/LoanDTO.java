package com.platus.loan_service.model.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanDTO {
    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    @Positive
    @DecimalMax("100.0")
    private BigDecimal interestRate;
}