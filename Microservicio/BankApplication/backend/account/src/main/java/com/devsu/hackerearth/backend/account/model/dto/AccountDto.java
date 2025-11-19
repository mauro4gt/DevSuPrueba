package com.devsu.hackerearth.backend.account.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class AccountDto {

    private String holderName;
    private String accountNumber;
    private BigDecimal balance;
    private String type;
    private Boolean isActive;
    private Long clientId;
    private List<TransactionDto> transactions;

    public AccountDto() {
    }

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

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public String getNumber() {
        return accountNumber;
    }

    public void setNumber(String number) {
        this.accountNumber = number;
    }

    public BigDecimal getInitialAmount() {
        return balance;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.balance = initialAmount;
    }
}
