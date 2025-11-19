package com.devsu.hackerearth.backend.account.model.dto;

import com.devsu.hackerearth.backend.account.model.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {

    private Long id;
    private String type;
    private BigDecimal amount;
    private LocalDateTime dateTransaction;
    private BigDecimal balanceAfter;
    private String description;
    private Long accountId;

    public TransactionDto() {
    }

    public TransactionDto(Long id, String type, BigDecimal amount, LocalDateTime dateTransaction, BigDecimal balanceAfter,
                          String description, Long accountId) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.dateTransaction = dateTransaction;
        this.balanceAfter = balanceAfter;
        this.description = description;
        this.accountId = accountId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public BigDecimal getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balanceAfter = balanceAfter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public static TransactionDto fromEntity(Transaction entity) {
        if (entity == null) {
            return null;
        }

        TransactionDto dto = new TransactionDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setAmount(entity.getAmount());
        dto.setBalanceAfter(entity.getBalanceAfter());
        dto.setDateTransaction(entity.getDateTransaction());
        dto.setDescription(entity.getDescription());

        if (entity.getAccount() != null) {
            dto.setAccountId(entity.getAccount().getId());
        }

        return dto;
    }
}
