package com.platus.transactional_service.web.service;


import com.platus.transactional_service.models.Balance;

import java.util.List;

public interface BalanceService {
    Balance createBalance(Balance balance);

    Balance getBalanceById(Long id);

    List<Balance> getAllBalances();

    Balance updateBalance(Long id, Balance balanceDetails);

    void deleteBalance(Long id);
}
