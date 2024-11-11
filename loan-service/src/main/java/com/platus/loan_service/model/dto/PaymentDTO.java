package com.platus.loan_service.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDTO {
    @NotNull
    @Positive
    private BigDecimal amount;
}