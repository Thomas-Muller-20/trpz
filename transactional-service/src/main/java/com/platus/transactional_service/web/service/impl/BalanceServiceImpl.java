package com.platus.transactional_service.web.service.impl;


import com.platus.transactional_service.exeption.ResourceNotFoundException;
import com.platus.transactional_service.models.Balance;
import com.platus.transactional_service.web.repository.BalanceRepository;
import com.platus.transactional_service.web.service.BalanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;

    @Override
    public Balance createBalance(Balance balance) {
        return balanceRepository.save(balance);
    }

    @Override
    public Balance getBalanceById(Long id) {
        return balanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Balance not found for this id :: " + id));
    }

    @Override
    public List<Balance> getAllBalances() {
        return balanceRepository.findAll();
    }

    @Override
    public Balance updateBalance(Long id, Balance balanceDetails) {
        Balance balance = balanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Balance not found for this id :: " + id));

        balance.setAmount(balanceDetails.getAmount());
        return balanceRepository.save(balance);
    }

    @Override
    public void deleteBalance(Long id) {
        Balance balance = balanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Balance not found for this id :: " + id));

        balanceRepository.delete(balance);
    }
}
