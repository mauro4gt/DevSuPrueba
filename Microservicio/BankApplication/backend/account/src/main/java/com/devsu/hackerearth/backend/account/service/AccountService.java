package com.devsu.hackerearth.backend.account.service;

import com.devsu.hackerearth.backend.account.model.dto.AccountDto;
import com.devsu.hackerearth.backend.account.model.Account;
import java.util.List;  

public interface AccountService {

    // Crear cuenta desde DTO
    Account createAccount(AccountDto accountDto);

    // Obtener cuenta por ID
    Account getAccountById(Long id);

    // Obtener todas las cuentas
    List<Account> getAllAccounts();

    // Actualizar cuenta
    Account updateAccount(Long id, AccountDto accountDetails);

    // Eliminar cuenta
    void deleteAccount(Long id);
}
