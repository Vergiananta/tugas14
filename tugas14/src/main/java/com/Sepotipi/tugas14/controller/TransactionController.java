package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Transaction;
import com.Sepotipi.tugas14.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/buy-album")
    public void buyByAlbum(@RequestBody Transaction transaction){
        transactionService.buyByAlbum(transaction);
    }

    @PostMapping("/buy-song")
    public void buyBySong(@RequestBody Transaction transaction){
        transactionService.buyBySong(transaction);
    }

    @GetMapping("/{id}")
    public void getTransaction(@PathVariable String id){
        transactionService.getTransactionById(id);
    }

}
