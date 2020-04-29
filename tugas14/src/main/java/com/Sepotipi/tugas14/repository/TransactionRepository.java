package com.Sepotipi.tugas14.repository;

import com.Sepotipi.tugas14.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionRepository extends JpaRepository<Transaction, String>, JpaSpecificationExecutor<Transaction> {
    public Page<Transaction> findAllByAmountLessThan(Double amount, Pageable pageable);
    public Page<Transaction> findAllByAmountGreaterThan(Double amount, Pageable pageable);
}
