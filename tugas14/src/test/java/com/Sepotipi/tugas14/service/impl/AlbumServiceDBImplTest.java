package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Account;
import com.Sepotipi.tugas14.entity.Album;
import com.Sepotipi.tugas14.repository.AlbumRepository;
import com.Sepotipi.tugas14.service.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class AlbumServiceDBImplTest {

    @MockBean
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void cleanAll(){
        albumRepository.deleteAll();
    }


    @Test
    void saveAlbum() {
        Album album = new Album();
        album.setTitle("Tes");
        album.setDescription("s");
        album.setDiscount(0.5);

        albumService.saveAlbum(album);
        albumRepository.save(album);

        List<Album>albums = new ArrayList<>();
        albums.add(album);

        when(albumRepository.findAll()).thenReturn(albums);
        assertEquals(1, albumRepository.findAll().size());

    }

    @Test
    void getAlbumById() {

        Album album = new Album();
        album.setId("asd");
        albumRepository.save(album);
        albumRepository.findById("asd");
//        albumRepository.findById("asd");
//        assertNotNull(album);
//       when(albumRepository.findById(album.getId())).thenReturn(Optional.of(album));
        assertEquals(album.getId(), albumRepository.findById("asd"));

    }

    @Test
    void deleteAlbum() {

        albumRepository.deleteById("id");

        Mockito.verify(albumRepository, Mockito.times(1)).deleteById("id");
    }

    @Test
    void searchAlbum() {
        albumRepository.findAllByTitleContainsAndDescriptionContains("a", "b", Pageable.unpaged());

        Mockito.verify(albumRepository, Mockito.times(1)).findAllByTitleContainsAndDescriptionContains("a", "b", Pageable.unpaged());

    }

    @Test
    void saveAlbumWithImage() {
    }
}