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
    public void buyByAlbum(@RequestBody Transaction transaction, @RequestParam String idSong, @RequestParam String idAlbum){
        transactionService.buyByAlbum(transaction, idSong, idAlbum);
    }

    @PostMapping("/buy-song")
    public void buyBySong(@RequestBody Transaction transaction, @RequestParam String idSong, @RequestParam String idAlbum){
        transactionService.buyBySong(transaction, idSong, idAlbum);
    }

}
