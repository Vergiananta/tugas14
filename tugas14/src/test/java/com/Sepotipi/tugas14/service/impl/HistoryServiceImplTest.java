package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.History;
import com.Sepotipi.tugas14.enums.HistoryTypeEnum;
import com.Sepotipi.tugas14.repository.HistoryRepository;
import com.Sepotipi.tugas14.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class HistoryServiceImplTest {

    @MockBean
    HistoryRepository historyRepository;

    @Autowired
    HistoryService historyService;

    @Test
    void saveHistory() {
        History history =  new History();
        history.setType(HistoryTypeEnum.TOPUP);
        history.setAmount(5000.0);
        history.setTrxDate(Timestamp.valueOf(LocalDateTime.now()));

        historyService.saveHistory(history);
        List<History>histories = new ArrayList<>();
        histories.add(history);

        Mockito.when(historyRepository.save(history)).thenReturn(history);

    }

    @Test
    void getHistory() {
    }

    @Test
    void getAllHistory() {
    }

    @Test
    void deleteHistory() {
    }
}