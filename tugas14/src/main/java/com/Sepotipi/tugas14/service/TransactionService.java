package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    public void buyByAlbum(Transaction transaction, String idAlbum, String idWallet);
    public void buyBySong(Transaction transaction, String idSong, String idWallet);
    public Transaction getTransactionById(String id);
    public void deleteTransaction(String id);
    public Page<Transaction> transaction(Pageable pageable);
}
