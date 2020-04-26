package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Wallet;
import com.Sepotipi.tugas14.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping
    public void saveWallet(@RequestBody Wallet wallet){

    }
}
