package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.History;
import com.Sepotipi.tugas14.entity.Wallet;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.HistoryRepository;
import com.Sepotipi.tugas14.service.HistoryService;
import com.Sepotipi.tugas14.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
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
        History history;
        if (historyRepository.findById(id).isPresent()) {
            history = historyRepository.findById(id).get();
        } else throw new ResourceNotFoundException(id, History.class);
        return history;
    }

    @Override
    public Page<History> getAllHistory(Pageable pageable) {
        Page<History> histories = historyRepository.findAll(pageable);
        return histories;
    }

    @Override
    public void deleteHistory(String id) {
        historyRepository.deleteById(id);
    }
}
