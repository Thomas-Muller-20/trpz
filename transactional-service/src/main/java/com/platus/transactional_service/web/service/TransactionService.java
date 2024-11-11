package com.platus.transactional_service.web.service;


import com.platus.transactional_service.models.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);
    Transaction updateTransaction(Long id, Transaction transaction);
    Transaction getTransactionById(Long id);
    List<Transaction> getAllTransactions();
    void deleteTransaction(Long id);
}
