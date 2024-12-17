package com.platus.transactional_service.web.controller;

import com.platus.transactional_service.models.Transaction;
import com.platus.transactional_service.utils.decorator.TransactionProcessor;
import com.platus.transactional_service.utils.templateMethod.ExpenseTransactionProcessor;
import com.platus.transactional_service.utils.templateMethod.IncomeTransactionProcessor;
import com.platus.transactional_service.utils.templateMethod.TransactionTemplateProcessor;
import com.platus.transactional_service.web.dto.TransactionRequest;
import com.platus.transactional_service.web.service.BalanceService;
import com.platus.transactional_service.web.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/processing/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final TransactionProcessor transactionProcessor;
    private BalanceService balanceService;


    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(transactionService.addTransaction(transaction), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Transaction transaction = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transaction);
    }


    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transactionDetails) {
        Transaction updatedTransaction = transactionService.updateTransaction(id, transactionDetails);
        return ResponseEntity.ok(updatedTransaction);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/process")
    public ResponseEntity<String> processTransaction(@RequestBody TransactionRequest request) {
        try {
            transactionProcessor.process(request);
            return ResponseEntity.ok("Transaction processed successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error processing transaction: " + e.getMessage());
        }
    }



    @PostMapping("/process-template")
    public ResponseEntity<Map<String, Object>> processTransaction(@RequestBody Transaction transaction) {
        TransactionTemplateProcessor processor = transaction.getType().equals("INCOME")
            ? new IncomeTransactionProcessor()
            : new ExpenseTransactionProcessor();
        try {
            return processor.processTransaction(transaction);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
