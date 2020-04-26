package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.entity.History;
import com.Sepotipi.tugas14.entity.Wallet;
import com.Sepotipi.tugas14.enums.HistoryTypeEnum;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.WalletRepository;
import com.Sepotipi.tugas14.service.HistoryService;
import com.Sepotipi.tugas14.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    HistoryService historyService;

    @Override
    public void saveWallet(Wallet wallet) {
            walletRepository.save(wallet);
    }

    @Override
    public void topUpWallet(Wallet wallet, Double topUpBalance) {
        History history = new History();
        wallet=walletRepository.findById(wallet.getId()).get();
        if (wallet.getAccount().getActive()==true){
            wallet.setBalance(wallet.getBalance()+topUpBalance);
            history.setType(HistoryTypeEnum.TOPUP);
            history.setTrxDate(new Timestamp(new Date().getTime()));
            history.setAmount(topUpBalance);
            history.setWallet(wallet);
            historyService.saveHistory(history);
            walletRepository.save(wallet);
        }
    }

    @Override
    public void withDrawalWallet(Wallet wallet, Double withDrawal) {
        History history = new History();
        if (wallet.getAccount().getActive()==true){
            wallet.setBalance(wallet.getBalance()-withDrawal);
            history.setType(HistoryTypeEnum.WITHDRAWAL);
            history.setTrxDate(new Timestamp(new Date().getTime()));
            history.setAmount(withDrawal);
            walletRepository.save(wallet);
            historyService.saveHistory(history);
        }
    }

    @Override
    public Wallet getWallet(String id) {
        Wallet wallet;

        if (walletRepository.findById(id).isPresent()){
            wallet = walletRepository.findById(id).get();
        } else throw new ResourceNotFoundException(id, Account.class);

        return wallet;
    }

    @Override
    public Page<Wallet> getAllWallet(Pageable pageable) {
        Page<Wallet> wallet = walletRepository.findAll(pageable);
        return wallet;
    }

    @Override
    public void deleteWallet(String id) {
        walletRepository.deleteById(id);
    }
}
