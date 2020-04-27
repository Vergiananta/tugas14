package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ArtistService {

    public Artist saveArtist(Artist artist);
    public Artist getArtistById (String id);
    public void deleteArtist(String id);
    public Page<Artist> searchArtist(Artist artist, Pageable pageable);
    public Artist saveArtistWithImage(MultipartFile file, String entity) throws IOException;
    public void uploadArtistWithImage(MultipartFile file, Artist entity) throws IOException;

}
