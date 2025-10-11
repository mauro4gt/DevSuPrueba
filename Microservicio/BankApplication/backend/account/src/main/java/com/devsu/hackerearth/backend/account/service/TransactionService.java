package com.devsu.hackerearth.backend.account.service;

// Update the import below to match the actual package of Transaction
import com.devsu.hackerearth.backend.account.model.Transaction;
import com.devsu.hackerearth.backend.account.model.dto.BankStatementDto;
import com.devsu.hackerearth.backend.account.model.dto.TransactionDto;

import java.math.BigDecimal;
import java.util.List;


import java.util.Date;



public interface TransactionService {
    List<TransactionDto> getAll();
    public TransactionDto getById(Long id);
    public TransactionDto create(TransactionDto transactionDto);
    public Transaction deposit(Long accountId, BigDecimal amount, String description);
    public Transaction withdraw(Long accountId, BigDecimal amount, String description);
    public Transaction transfer(Long fromAccountId, Long toAccountId, BigDecimal amount, String description);
    public List<Transaction> getTransactionsByAccount(Long accountId);
    public List<BankStatementDto> getAllByAccountClientIdAndDateBetween(
            Long clientId, Date start, Date end);
}
