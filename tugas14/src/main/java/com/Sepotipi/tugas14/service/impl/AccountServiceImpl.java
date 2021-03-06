package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.entity.Wallet;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.AccountRepository;
import com.Sepotipi.tugas14.service.AccountService;
import com.Sepotipi.tugas14.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    WalletService walletService;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void signUp(Account account) {
        Wallet wallet = new Wallet();
        wallet.setBalance(0.0);
        wallet.setAccount(account);
        walletService.saveWallet(wallet);
        accountRepository.save(account);
    }

    @Override
    public Account getAccount(String id) {
       Account accounts;

        if (accountRepository.findById(id).isPresent()) {
            accounts = accountRepository.findById(id).get();
        } else throw new ResourceNotFoundException(id, Account.class);
        return accounts;
    }

    @Override
    public Page<Account> getAllAccount(Pageable pageable) {
        Page<Account> accounts = accountRepository.findAll(pageable);
        return accounts;
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
