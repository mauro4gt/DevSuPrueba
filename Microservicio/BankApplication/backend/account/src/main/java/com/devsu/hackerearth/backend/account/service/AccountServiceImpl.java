package com.devsu.hackerearth.backend.account.service;

import com.devsu.hackerearth.backend.account.exception.ResourceNotFoundException;
import com.devsu.hackerearth.backend.account.model.Account;
import com.devsu.hackerearth.backend.account.model.dto.AccountDto;
import com.devsu.hackerearth.backend.account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Crear cuenta desde DTO
    @Override
    public Account createAccount(AccountDto dto) {
        Account account = new Account();
        
        // Asignar valores del DTO a la entidad
        account.setNumber(dto.getNumber() != null ? dto.getNumber() : generateAccountNumber());
        account.setAccountNumber(dto.getAccountNumber());
        account.setInitialAmount(dto.getInitialAmount());
        account.setType(dto.getType());
        account.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        account.setClientId(dto.getClientId());
        
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cuenta no encontrada con ID: " + id));
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Long id, AccountDto dto) {
        Account account = getAccountById(id);

        // Actualizar campos
        account.setNumber(dto.getNumber() != null ? dto.getNumber() : account.getNumber());
        account.setAccountNumber(dto.getAccountNumber() != null ? dto.getAccountNumber() : account.getAccountNumber());
        account.setInitialAmount(dto.getInitialAmount() != null ? dto.getInitialAmount() : account.getInitialAmount());
        account.setType(dto.getType() != null ? dto.getType() : account.getType());
        account.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : account.getIsActive());
        account.setClientId(dto.getClientId() != null ? dto.getClientId() : account.getClientId());

        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = getAccountById(id);
        accountRepository.delete(account);
    }

    // Generar número de cuenta automático si no se proporciona
    private String generateAccountNumber() {
        return "ACC-" + System.currentTimeMillis();
    }
}
