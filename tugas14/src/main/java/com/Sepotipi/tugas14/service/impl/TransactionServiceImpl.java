package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.Jpa.TransactionJpaSpescification;
import com.Sepotipi.tugas14.entity.*;
import com.Sepotipi.tugas14.enums.HistoryTypeEnum;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.TransactionRepository;
import com.Sepotipi.tugas14.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    TransactionService transactionService;

    @Autowired
    AlbumService albumService;

    @Autowired
    SongService songService;

    @Autowired
    WalletService walletService;

    @Autowired
    HistoryService historyService;

    @Override
    public void buyByAlbum(Transaction transaction) {
        Wallet wallet = walletService.getWallet(transaction.getWallet().getId());
//        Song song = songService.getSongById(transaction.getItem().getId());
        History history = new History();

        Album album = albumService.getAlbumById(transaction.getAlbumId());

        for (Song song1: album.getSongs()) {
            if (wallet.getBalance() > song1.getPrice()){
                Transaction transaction1 = new Transaction();
                transaction1.setAlbumDiscount(song1.getPrice() * album.getDiscount());
                transaction1.setAmount(song1.getPrice() - transaction1.getAlbumDiscount());
                transaction1.setItem(song1);
                transaction1.setTrxDate(new Timestamp(new Date().getTime()));
                transaction1.setWallet(wallet);
                transactionRepository.save(transaction1);
                wallet.setBalance(wallet.getBalance()-song1.getPrice());
                walletService.saveWallet(wallet);
                history.setAmount(song1.getPrice());
                history.setType(HistoryTypeEnum.PAYMENT);
                history.setTrxDate(new Timestamp(new Date().getTime()));
                history.setWallet(wallet);
            }
        }
            historyService.saveHistory(history);
        }


    @Override
    public void buyBySong(Transaction transaction) {
        Wallet wallet = walletService.getWallet(transaction.getWallet().getId());
        Song song = songService.getSongById(transaction.getItem().getId());
        History history = new History();
        Transaction transaction1 = new Transaction();
//        transaction = transactionRepository.findById(transaction.getId()).get();
        if (wallet.getAccount().getActive() == true) {
            transaction1.setTrxDate(new Timestamp(new Date().getTime()));
            transaction1.setAlbumDiscount(0.0);
            transaction1.setItem(song);
            transaction1.setAmount(song.getPrice());
            transaction1.setWallet(wallet);
            transactionRepository.save(transaction1);
            wallet.setBalance(wallet.getBalance() - song.getPrice());
            walletService.saveWallet(wallet);
            history.setAmount(song.getPrice());
            history.setType(HistoryTypeEnum.PAYMENT);
            history.setTrxDate(new Timestamp(new Date().getTime()));
            history.setWallet(wallet);
            historyService.saveHistory(history);


        }
    }


    @Override
    public Transaction getTransactionById(String id) {
        Transaction transaction;
        Song song = new Song();

        if (transactionRepository.findById(id).isPresent()){

            transaction = transactionRepository.findById(id).get();
            transaction.setAlbumId(song.getAlbum().getId());
        } else throw new ResourceNotFoundException(id, Transaction.class);

        return transaction;
    }

    @Override
    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Page<Transaction> transaction(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);
        return transactions;
    }

    @Override
    public Page<Transaction> searchAmountLessThan(Transaction transaction, Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAllByAmountLessThan(transaction.getAmount(), pageable);
        return transactions;
    }
    @Override
    public Page<Transaction> searchAmountGreatherThan(Transaction transaction, Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAllByAmountGreaterThan(transaction.getAmount(), pageable);
        return transactions;
    }

//    @Override
//    public Page<Transaction> searchArtistByField(Pageable pageable, Transaction searchForm) {
//        Page<Transaction> transactions = transactionRepository.findAll(TransactionJpaSpescification.findByLessThanAmount(searchForm), pageable);
//        return transactions;
//    }
}
