package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.entity.History;
import com.Sepotipi.tugas14.entity.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WalletService {
    public void saveWallet(Wallet wallet);
    public Wallet getWallet(String id);
    public Page<Wallet> getAllWallet(Pageable pageable);
    public void deleteWallet(String id);
    public void topUpWallet(Wallet wallet, Double balance);
    public void withDrawalWallet(Wallet wallet, Double withDrawal);
}
