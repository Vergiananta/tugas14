package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/buy-album")
    public void buyByAlbum(){

    }

}
