package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.entity.History;
import com.Sepotipi.tugas14.entity.Wallet;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.WalletRepository;
import com.Sepotipi.tugas14.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    WalletRepository walletRepository;



    @Override
    public void saveWallet(Wallet wallet) {
//        if (wallet.getAccount().getActive().equals(true)) {
//
//            wallet.setHistories(.setAmount());
//            wallet = walletRepository.save(wallet);
//        } else {
//            System.out.println("Sorry Account UnActive");
//        }
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
