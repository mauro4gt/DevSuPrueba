package com.devsu.hackerearth.backend.account.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.devsu.hackerearth.backend.account.model.Transaction;

@Getter
@Setter
public class BankStatementDto {

    private Long id;
    private String type;
    private BigDecimal amount;
    private BigDecimal balanceAfter;
    private LocalDateTime dateTransaction;
    private String description;
    private Long accountId;

    public static BankStatementDto fromEntity(Transaction transaction) {
        if (transaction == null) return null;

        BankStatementDto dto = new BankStatementDto();
        dto.setId(transaction.getId());
        dto.setType(transaction.getType());
        dto.setAmount(transaction.getAmount());
        dto.setBalanceAfter(transaction.getBalanceAfter());
        dto.setDateTransaction(transaction.getDateTransaction());
        dto.setDescription(transaction.getDescription());
        if (transaction.getAccount() != null) {
            dto.setAccountId(transaction.getAccount().getId());
        }
        return dto;
    }
}
