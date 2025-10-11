package com.devsu.hackerearth.backend.account.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AccountDto {

    private String holderName;
    private String accountNumber;
    private BigDecimal balance;
    private String type;
    private Boolean isActive;
    private Long clientId;
    private List<TransactionDto> transactions;

    // ===== Getters/Setters compatibles con Account =====
    public String getNumber() { return accountNumber; }
    public void setNumber(String number) { this.accountNumber = number; }

    public BigDecimal getInitialAmount() { return balance; }
    public void setInitialAmount(BigDecimal initialAmount) { this.balance = initialAmount; }

    // Constructor vacío
    public AccountDto() {}

    // Constructor completo
    public AccountDto(String holderName, String accountNumber, BigDecimal balance, String type,
                      Boolean isActive, Long clientId, List<TransactionDto> transactions) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.isActive = isActive;
        this.clientId = clientId;
        this.transactions = transactions;
    }
}

