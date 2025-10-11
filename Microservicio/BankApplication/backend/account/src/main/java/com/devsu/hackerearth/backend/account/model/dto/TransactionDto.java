package com.devsu.hackerearth.backend.account.model.dto;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.devsu.hackerearth.backend.account.model.Transaction;

@Getter
@Setter
public class TransactionDto {

    private Long id;
    private String type;
    private BigDecimal amount;
    private LocalDateTime dateTransaction;
    private BigDecimal balanceAfter;
    private String description;
    private Long accountId;

    // ===== Mapper desde entidad =====
    public static TransactionDto fromEntity(Transaction entity) {
        if (entity == null) {
            return null; // Manejo de nulo
        }

        TransactionDto dto = new TransactionDto();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setAmount(entity.getAmount());
        dto.setBalanceAfter(entity.getBalanceAfter());
        dto.setDateTransaction(entity.getDateTransaction());
        dto.setDescription(entity.getDescription());

        // Verificar que la cuenta exista
        if (entity.getAccount() != null) {
            dto.setAccountId(entity.getAccount().getId());
        }

        return dto;
    }
}
