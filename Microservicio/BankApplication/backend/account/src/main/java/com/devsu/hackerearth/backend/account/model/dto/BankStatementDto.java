package com.devsu.hackerearth.backend.account.model.dto;

import com.devsu.hackerearth.backend.account.model.Transaction;
import java.time.LocalDate;
import java.util.List;

public class BankStatementDto {

    private String holderName;
    private String accountNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<TransactionDto> transactions;

    public BankStatementDto() {
    }

    public BankStatementDto(String holderName, String accountNumber, LocalDate startDate, LocalDate endDate,
                            List<TransactionDto> transactions) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public static BankStatementDto fromEntity(Transaction transaction) {
        if (transaction == null || transaction.getAccount() == null) {
            return null;
        }

        BankStatementDto dto = new BankStatementDto();
        dto.setAccountNumber(transaction.getAccount().getAccountNumber());
        dto.setHolderName(transaction.getAccount().getNumber());
        dto.setStartDate(transaction.getDateTransaction() != null ? transaction.getDateTransaction().toLocalDate() : null);
        dto.setEndDate(dto.getStartDate());
        dto.setTransactions(List.of(TransactionDto.fromEntity(transaction)));
        return dto;
    }
}
