package com.devsu.hackerearth.backend.account.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devsu.hackerearth.backend.account.model.dto.BankStatementDto;
import com.devsu.hackerearth.backend.account.model.dto.TransactionDto;
import com.devsu.hackerearth.backend.account.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionDto> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/{id}")
    public TransactionDto getById(@PathVariable Long id) {
        return transactionService.getById(id);
    }

    @PostMapping
    public TransactionDto create(@RequestBody TransactionDto transactionDto) {
        return transactionService.create(transactionDto);
    }

    // 📊 F4: Reporte de estado de cuenta
    @GetMapping("/clients/{clientId}/report")
    public List<BankStatementDto> getReport(
            @PathVariable Long clientId,
            @RequestParam("dateTransactionStart") Date dateTransactionStart,
            @RequestParam("dateTransactionEnd") Date dateTransactionEnd) {

        return transactionService.getAllByAccountClientIdAndDateBetween(
                clientId, dateTransactionStart, dateTransactionEnd);
    }
}
