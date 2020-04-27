package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Artist;
import com.Sepotipi.tugas14.enums.GenderEnum;
import com.Sepotipi.tugas14.repository.ArtistRepository;
import com.Sepotipi.tugas14.service.ArtistService;
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
class ArtistServiceDBImplTest {

    @MockBean
    ArtistRepository artistRepository;

    @Autowired
    ArtistService artistService;

    @Test
    void saveArtist() {
        Artist artist = new Artist();
        artist.setName("name");
        artist.setBiography("sad");
        artist.setDebutYear(2001);
        artist.setGender(GenderEnum.MALE);

        artistRepository.save(artist);

        List<Artist>artists = new ArrayList<>();
        artists.add(artist);

        Mockito.when(artistRepository.save(artist)).thenReturn(artist);
    }

    @Test
    void getArtistById() {

        artistRepository.findById("id");

        Mockito.verify(artistRepository, Mockito.times(1)).findById("id");
    }

    @Test
    void deleteArtist() {
        artistRepository.deleteById("id");

        Mockito.verify(artistRepository, Mockito.times(1)).deleteById("id");
    }

    @Test
    void searchArtist() {
        artistRepository.findAllByNameContains("a", Pageable.unpaged());

        Mockito.verify(artistRepository, Mockito.times(1)).findAllByNameContains("a", Pageable.unpaged());
    }

    @Test
    void saveArtistWithImage() {
        Artist artist = new Artist();
        artist.setPhoto("foto");

        artistRepository.save(artist);
        Mockito.when(artistRepository.save(artist)).thenReturn(artist);
    }
}