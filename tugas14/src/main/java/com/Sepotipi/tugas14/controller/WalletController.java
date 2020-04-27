package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.History;
import com.Sepotipi.tugas14.entity.Wallet;
import com.Sepotipi.tugas14.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    WalletService walletService;

    @PostMapping("/withdrawal/{id}")
    public void withdrawalUpdate(@PathVariable String id,@RequestBody Wallet wallet, @RequestParam Double withdrawal){
        walletService.withDrawalWallet(wallet, withdrawal);
    }
    @PostMapping("/first-top-up")
    public void firstTopUp(@RequestBody Wallet wallet){
        walletService.saveWallet(wallet);
    }

    @PostMapping("/top-up")
    public void topUpWallet(@RequestBody Wallet wallet, @RequestParam Double topUpBalance){
     walletService.topUpWallet(wallet,topUpBalance);
    }
    @PostMapping("/top-up/{id}")
    public void topUpWallet2(@PathVariable String id,@RequestBody Wallet wallet, @RequestParam Double topUpBalance){
        walletService.topUpWallet(wallet, topUpBalance);
    }
    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable String id){
        return walletService.getWallet(id);
    }

    @GetMapping
    public Page<Wallet> getAllWallet(@RequestParam(name = "page") Integer page,@RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return walletService.getAllWallet(pageable);
    }


}
