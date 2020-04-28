package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    public void signUp(Account account);
    public Account getAccount(String id);
    public Page<Account> getAllAccount(Pageable pageable);
    public void deleteAccount(String id);

}
