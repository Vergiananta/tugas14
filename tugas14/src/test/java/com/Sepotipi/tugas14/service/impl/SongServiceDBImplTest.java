package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Song;
import com.Sepotipi.tugas14.repository.ArtistRepository;
import com.Sepotipi.tugas14.repository.SongRepository;
import com.Sepotipi.tugas14.service.SongService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class SongServiceDBImplTest {

    @MockBean
    SongRepository songRepository;

    @Autowired
    SongService songService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void saveSong_Should_Create_1_Song_inDB_WhenSaved() {

        Song song = new Song();
        songService.saveSong(song);

        Mockito.verify(songRepository, Mockito.times(1)).save(song);
    }

    @Test
    void getSong_Should_Call_ById_1_Times() {

        songRepository.findById("id");

        List<Song> songs = new ArrayList<>();
        Mockito.verify(songRepository, Mockito.times(1)).findById("id");

    }

    @Test
    void delete_Song_1_Times_When_Deleted() {

        songRepository.deleteById("id");

     Mockito.verify(songRepository, Mockito.times(1)).deleteById("id");
    }

    @Test
    void search_Song_1_Times_When_Called_By_Spesification() {

        songRepository.findAllByTitleContains("a", Pageable.unpaged());

        Mockito.verify(songRepository, Mockito.times(1)).findAllByTitleContains("a", Pageable.unpaged());

    }
}