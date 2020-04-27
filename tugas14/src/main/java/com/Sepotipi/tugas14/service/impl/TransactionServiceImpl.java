package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Transaction;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.TransactionRepository;
import com.Sepotipi.tugas14.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Transaction buyByAlbum(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction buyBySong(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction getTransactionById(String id) {
        Transaction transaction;
        if (transactionRepository.findById(id).isPresent()){
            transaction = transactionRepository.findById(id).get();
        } else throw new ResourceNotFoundException(id, Transaction.class);

        return transaction;
    }

    @Override
    public void deleteSong(String id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Page<Transaction> transaction(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);
        return transactions;
    }
}
