package com.devsu.hackerearth.backend.account.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends Base {

    @Column(nullable = false)
    private String accountNumber;

    @Column(precision = 18, scale = 2)
    private BigDecimal balance;

    private LocalDateTime createdAt;

    @Column(unique = true, nullable = false)
    private String number;

    private String type;

    @Column(name = "initial_amount", precision = 18, scale = 2)
    private BigDecimal initialAmount;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "client_id")
    private Long clientId;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    // ===== Getters =====
    public String getNumber() { return number; }
    public String getType() { return type; }
    public BigDecimal getInitialAmount() { return initialAmount; }
    public Boolean getIsActive() { return isActive; }
    public Long getClientId() { return clientId; }
    public List<Transaction> getTransactions() { return transactions; }

    public BigDecimal getBalance() {
        if (transactions != null) {
            return initialAmount != null ? initialAmount : BigDecimal.ZERO;
        }
        return BigDecimal.ZERO; // <-- cierra correctamente el método
    }

    // ===== Setters =====
    public void setNumber(String number) { this.number = number; }
    public void setType(String type) { this.type = type; }
    public void setInitialAmount(BigDecimal initialAmount) { this.initialAmount = initialAmount; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public void setClientId(Long clientId) { this.clientId = clientId; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
    public void setBalance(BigDecimal balance) { this.initialAmount = balance; }
}
