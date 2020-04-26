package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.History;
import com.Sepotipi.tugas14.repository.HistoryRepository;
import com.Sepotipi.tugas14.service.HistoryService;
import com.Sepotipi.tugas14.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class HistoryServiceImpl implements HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    WalletService walletService;

    @Override
    public History saveHistory(History history) {



        return historyRepository.save(history);
    }

    @Override
    public History getHistory(String id) {

        return null;
    }

    @Override
    public Page<History> getAllHistory(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteHistory(String id) {

    }
}
