package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Genre;
import com.Sepotipi.tugas14.repository.GenreRepository;
import com.Sepotipi.tugas14.service.GenreService;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class GenreServiceDBImplTest {

    @MockBean
    GenreRepository genreRepository;

    @Autowired
    GenreService genreService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void add_Genre_1_Times_When_Saved() {
        Genre genre = new Genre();

        genre.setName("Pop");

        genreRepository.save(genre);
        List<Genre>genres = new ArrayList<>();
        genres.add(genre);

        Mockito.when(genreRepository.save(genre)).thenReturn(genre);

    }

    @Test
    void getGenre_Should_Call_ById_1_Times() {

        genreRepository.findById(1);

        Mockito.verify(genreRepository, Mockito.times(1)).findById(1);

    }

    @Test
    void delete_Song_1_Times_When_Deleted() {

        genreRepository.deleteById(1);

        Mockito.verify(genreRepository, Mockito.times(1)).deleteById(1);
    }

    @Test
    void search_Song_1_Times_When_Called_By_Spesification() {

        genreRepository.findAllByNameContains("a", Pageable.unpaged());

        Mockito.verify(genreRepository, Mockito.times(1)).findAllByNameContains("a", Pageable.unpaged());
    }
}