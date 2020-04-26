package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoryService {

    public History saveHistory(History history);
    public History getHistory(String id);
    public Page<History> getAllHistory(Pageable pageable);
    public void deleteHistory(String id);
}
