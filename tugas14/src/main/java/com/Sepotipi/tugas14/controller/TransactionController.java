package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Transaction;
import com.Sepotipi.tugas14.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/search-less")
    public Page<Transaction> searchLessAmount(@RequestBody Transaction transaction, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return transactionService.searchAmountLessThan(transaction,pageable);
    }

    @GetMapping("/search-greather")
    public Page<Transaction> searchGreatherThanByAmount(@RequestBody Transaction transaction, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return transactionService.searchAmountGreatherThan(transaction,pageable);
    }

    @GetMapping("/search-title")
    public Page<Transaction> searchByTitle(@RequestBody Transaction transaction, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return  transactionService.searcByTitle(transaction, pageable);
    }
}
