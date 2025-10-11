package com.devsu.hackerearth.backend.account.service;

import com.devsu.hackerearth.backend.account.model.Transaction;
import com.devsu.hackerearth.backend.account.model.Account;
import com.devsu.hackerearth.backend.account.model.dto.TransactionDto;
import com.devsu.hackerearth.backend.account.model.dto.BankStatementDto;
import com.devsu.hackerearth.backend.account.repository.AccountRepository;
import com.devsu.hackerearth.backend.account.repository.TransactionRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    // ✅ Obtener todas las transacciones
    @Override
    public List<TransactionDto> getAll() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionDto::fromEntity)
                .collect(Collectors.toList());
    }

    // ✅ Obtener una transacción por ID
    public TransactionDto getById(Long id) {
        return transactionRepository.findById(id)
                .map(TransactionDto::fromEntity)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
    }

    // ✅ Crear nueva transacción
    public TransactionDto create(TransactionDto transactionDto) {
        Account account = accountRepository.findById(transactionDto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(transactionDto.getAmount());
        transaction.setDescription(transactionDto.getDescription());
        transaction.setType(transactionDto.getType());
        transaction.setDate(new Date());

        Transaction saved = transactionRepository.save(transaction);
        return TransactionDto.fromEntity(saved);
    }

    // ✅ Implementaciones de operaciones financieras
    @Override
    public Transaction deposit(Long accountId, BigDecimal amount, String description) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance().add(amount));

        Transaction t = new Transaction();
        t.setAccount(account);
        t.setAmount(amount);
        t.setDescription(description);
        t.setType("DEPOSIT");
        t.setDate(new Date());

        accountRepository.save(account);
        return transactionRepository.save(t);
    }

    @Override
    public Transaction withdraw(Long accountId, BigDecimal amount, String description) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0)
            throw new RuntimeException("Insufficient balance");

        account.setBalance(account.getBalance().subtract(amount));

        Transaction t = new Transaction();
        t.setAccount(account);
        t.setAmount(amount.negate());
        t.setDescription(description);
        t.setType("WITHDRAWAL");
        t.setDate(new Date());

        accountRepository.save(account);
        return transactionRepository.save(t);
    }

    @Override
    public Transaction transfer(Long fromAccountId, Long toAccountId, BigDecimal amount, String description) {
        withdraw(fromAccountId, amount, "Transfer to account " + toAccountId);
        deposit(toAccountId, amount, "Transfer from account " + fromAccountId);
        return null; // o retornar un DTO de confirmación
    }

    @Override
    public List<Transaction> getTransactionsByAccount(Long accountId) {
        return transactionRepository.findAllByAccountId(accountId);
    }

    // ✅ Reporte de movimientos por cliente y rango de fechas
    public List<BankStatementDto> getAllByAccountClientIdAndDateBetween(
            Long clientId, Date start, Date end) {

        return transactionRepository
                .findAllByAccountClientIdAndDateBetween(clientId, start, end)
                .stream()
                .map(BankStatementDto::fromEntity)
                .collect(Collectors.toList());
    }
}
