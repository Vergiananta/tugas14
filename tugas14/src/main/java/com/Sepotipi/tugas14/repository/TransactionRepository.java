package com.Sepotipi.tugas14.repository;

import com.Sepotipi.tugas14.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
