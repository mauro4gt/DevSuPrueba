package com.devsu.hackerearth.backend.account.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.ZoneId;

@Entity
@Table(name = "transactions")
public class Transaction extends Base {

    @Column(nullable = false)
    private LocalDateTime dateTransaction;

    @Column(length = 20)
    private String type; // DEPOSIT, WITHDRAWAL, TRANSFER

    @Column(precision = 18, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(precision = 18, scale = 2)
    private BigDecimal balanceAfter;

    @Column(length = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    // ===== Getters =====
    public LocalDateTime getDateTransaction() { return dateTransaction; }
    public String getType() { return type; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getBalanceAfter() { return balanceAfter; }
    public String getDescription() { return description; }
    public Account getAccount() { return account; }

    // Métodos Date compatibles
    public Date getDate() {
        return dateTransaction != null ? Date.from(dateTransaction.atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    public void setDate(Date date) {
        if (date != null) {
            this.dateTransaction = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        }
    }

    // ===== Setters =====
    public void setDateTransaction(LocalDateTime dateTransaction) { this.dateTransaction = dateTransaction; }
    public void setType(String type) { this.type = type; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setBalanceAfter(BigDecimal balanceAfter) { this.balanceAfter = balanceAfter; }
    public void setDescription(String description) { this.description = description; }
    public void setAccount(Account account) { this.account = account; }
}
