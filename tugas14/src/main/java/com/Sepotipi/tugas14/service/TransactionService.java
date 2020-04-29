package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    public void buyByAlbum(Transaction transaction);
    public void buyBySong(Transaction transaction);
    public Transaction getTransactionById(String id);
    public void deleteTransaction(String id);
    public Page<Transaction> transaction(Pageable pageable);
    public Page<Transaction> searcByTitle(Transaction transaction, Pageable pageable);
    public Page<Transaction> searchAmountLessThan(Transaction transaction, Pageable pageable);
    public Page<Transaction> searchAmountGreatherThan(Transaction transaction, Pageable pageable);

}
