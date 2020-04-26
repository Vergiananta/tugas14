package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Wallet;
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

    }

    @Override
    public Wallet getWallet(String id) {
        return null;
    }

    @Override
    public Page<Wallet> getAllWallet(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteWallet(String id) {

    }
}
