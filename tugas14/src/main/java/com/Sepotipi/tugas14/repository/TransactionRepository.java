package com.Sepotipi.tugas14.repository;

import com.Sepotipi.tugas14.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    public Page<Transaction> findAllByAmountLessThan(Double amount, Pageable pageable);
    public Page<Transaction> findAllByAmountGreaterThan(Double amount, Pageable pageable);
}
