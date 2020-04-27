package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    public Transaction buyByAlbum(Transaction transaction);
    public Transaction buyBySong(Transaction transaction);
    public Transaction getTransactionById(String id);
    public void deleteSong(String id);
    public Page<Transaction> transaction(Pageable pageable);
}
