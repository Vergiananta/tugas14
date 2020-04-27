package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.Jpa.TransactionJpaSpescification;
import com.Sepotipi.tugas14.entity.*;
import com.Sepotipi.tugas14.enums.HistoryTypeEnum;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.TransactionRepository;
import com.Sepotipi.tugas14.service.AlbumService;
import com.Sepotipi.tugas14.service.SongService;
import com.Sepotipi.tugas14.service.TransactionService;
import com.Sepotipi.tugas14.service.WalletService;
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

    @Override
    public void buyByAlbum(Transaction transaction, String idAlbum , String idWallet) {
        Wallet wallet = new Wallet();
        History history =  new History();
        Song song = songService.getSongById(transaction.getItem().getId());
        Album album = albumService.getAlbumById(idAlbum);

        for (Song song1: album.getSongs()) {

            if (transaction.getWallet().getAccount().getActive() == true){
               if (transaction.getWallet().getBalance().equals(transaction.getAmount())){

                transaction.setAlbumDiscount(song.getPrice() * album.getDiscount());
                transaction.setAmount(song.getPrice() - transaction.getAlbumDiscount());
                transaction.setItem(song1);
                transaction.setTrxDate(new Timestamp(new Date().getTime()));
                transaction.setWallet(walletService.getWallet(idWallet));
                   wallet.setBalance(transaction.getWallet().getBalance()-song.getPrice());
                   history.setAmount(song.getPrice());
                   history.setType(HistoryTypeEnum.PAYMENT);
                   history.setTrxDate(new Timestamp(new Date().getTime()));
                   history.setWallet(wallet);
                }
            } else throw new ResourceNotFoundException(idAlbum, Album.class);
            transactionRepository.save(transaction);
        }
    }

    @Override
    public void buyBySong(Transaction transaction, String idSong, String idWallet) {
        Wallet wallet = new Wallet();
        History history = new History();
        Song song = songService.getSongById(idSong);
        if (transaction.getWallet().getAccount().getActive()==true){
            transaction.setTrxDate(new Timestamp(new Date().getTime()));
            transaction.setItem(songService.getSongById(idSong));
            transaction.setWallet(walletService.getWallet(idWallet));
            transaction.setAlbumDiscount(0.0);
            wallet.setBalance(transaction.getWallet().getBalance()-song.getPrice());
            history.setAmount(song.getPrice());
            history.setType(HistoryTypeEnum.PAYMENT);
            history.setTrxDate(new Timestamp(new Date().getTime()));
            history.setWallet(wallet);
        } else throw new ResourceNotFoundException(idSong, Song.class);
        transactionRepository.save(transaction);
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
    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Page<Transaction> transaction(Pageable pageable) {
        Page<Transaction> transactions = transactionRepository.findAll(pageable);
        return transactions;
    }

//    @Override
//    public Page<Transaction> searchArtistByField(Pageable pageable, Transaction searchForm) {
//        Page<Transaction> transactions = transactionRepository.findAll(TransactionJpaSpescification.findByLessThanAmount(searchForm), pageable);
//        return transactions;
//    }
}
