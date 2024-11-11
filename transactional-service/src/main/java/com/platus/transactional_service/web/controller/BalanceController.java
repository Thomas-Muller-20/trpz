package com.platus.transactional_service.web.controller;
import com.platus.transactional_service.models.Balance;
import com.platus.transactional_service.web.service.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/processing/balances")
@AllArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;


    @PostMapping
    public ResponseEntity<Balance> createBalance(@RequestBody Balance balance) {
        Balance createdBalance = balanceService.createBalance(balance);
        return new ResponseEntity<>(createdBalance, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Balance> getBalanceById(@PathVariable Long id) {
        Balance balance = balanceService.getBalanceById(id);
        return ResponseEntity.ok(balance);
    }


    @GetMapping
    public ResponseEntity<List<Balance>> getAllBalances() {
        List<Balance> balances = balanceService.getAllBalances();
        return ResponseEntity.ok(balances);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Balance> updateBalance(@PathVariable Long id, @RequestBody Balance balanceDetails) {
        Balance updatedBalance = balanceService.updateBalance(id, balanceDetails);
        return ResponseEntity.ok(updatedBalance);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBalance(@PathVariable Long id) {
        balanceService.deleteBalance(id);
        return ResponseEntity.noContent().build();
    }
}