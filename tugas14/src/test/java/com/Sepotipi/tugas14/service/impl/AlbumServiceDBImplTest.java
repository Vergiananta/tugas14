package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Album;
import com.Sepotipi.tugas14.repository.AlbumRepository;
import com.Sepotipi.tugas14.service.AlbumService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class AlbumServiceDBImplTest {

    @MockBean
    AlbumRepository albumRepository;

    @Autowired
    AlbumService albumService;

    @Test
    void saveAlbum() {
        Album album = new Album();
        album.setTitle("Tes");
        album.setDescription("s");
        album.setDiscount(0.5);

        albumRepository.save(album);
        List<Album> albums = new ArrayList<>();
        albums.add(album);

        Mockito.when(albumRepository.save(album)).thenReturn(album);
    }

    @Test
    void getAlbumById() {

        albumRepository.findById("id");

        Mockito.verify(albumRepository, Mockito.times(1)).findById("id");

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