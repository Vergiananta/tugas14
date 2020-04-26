package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.repository.AccountRepository;
import com.Sepotipi.tugas14.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class AccountServiceImplTest {

    @MockBean
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Test
    void saveAccount() {
        Account account = new Account();

        accountRepository.save(account);

        List<Account>accounts = new ArrayList<>();
        accounts.add(account);

        Mockito.when(accountRepository.save(account)).thenReturn(account);

    }

    @Test
    void getAccount() {

        accountService.getAccount("id").equals(accountService.getAccount("id"));

        Mockito.verify(accountRepository, Mockito.times(1)).findById("id");

    }

    @Test
    void getAllAccount() {

        accountService.getAllAccount(Pageable.unpaged());

        Mockito.verify(accountRepository, Mockito.atLeast(1)).findAll(Pageable.unpaged());
    }

    @Test
    void deleteAccount() {

        accountService.deleteAccount("id");

        Mockito.verify(accountRepository, Mockito.times(1)).deleteById("id");

    }
}