package com.devsu.hackerearth.backend.account.repository;

import com.devsu.hackerearth.backend.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByAccountId(Long accountId);

    List<Transaction> findAllByAccountClientIdAndDateBetween(
            Long clientId,
            Date dateTransactionStart,
            Date dateTransactionEnd);
}
