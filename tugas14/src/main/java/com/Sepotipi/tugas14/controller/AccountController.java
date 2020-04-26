package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/sign-up")
    public void saveAccount(@RequestBody Account account){
        accountService.saveAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable String id){
        return accountService.getAccount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        accountService.deleteAccount(id);
    }

    @GetMapping
    public Page<Account> getAllAccount(@RequestParam(name = "page") Integer page,@RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return accountService.getAllAccount(pageable);
    }

}
