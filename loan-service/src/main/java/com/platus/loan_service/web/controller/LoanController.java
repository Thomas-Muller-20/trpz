package com.platus.loan_service.web.controller;

import com.platus.loan_service.model.Loan;
import com.platus.loan_service.model.dto.LoanDTO;
import com.platus.loan_service.model.dto.PaymentDTO;
import com.platus.loan_service.service.LoanService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/loans")
@AllArgsConstructor
public class LoanController {
    private final LoanService loanService;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        return loanService.getLoanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/payments")
    public ResponseEntity<Loan> makePayment(
            @PathVariable Long id,
            @RequestBody @Valid PaymentDTO paymentDTO) {
        return ResponseEntity.ok(loanService.makePayment(id, paymentDTO));
    }
    @PostMapping("/{id}/interest")
    public ResponseEntity<Void> calculateInterest(@PathVariable Long id) {
        loanService.calculateMonthlyInterest(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/close")
    public ResponseEntity<Loan> closeLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.closeLoan(id));
    }
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody @Valid LoanDTO loanDTO) {
        return ResponseEntity.ok(loanService.createLoan(loanDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {
        return ResponseEntity.ok(loanService.updateLoan(id, loanDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
