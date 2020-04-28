package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Album;
import com.Sepotipi.tugas14.entity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AlbumService {


    public Album saveAlbum(Album album);
    public Album getAlbumById (String id);
    public void deleteAlbum(String id);
    public Page<Album> searchAlbum(Album album, Pageable pageable);
    public Album saveAlbumWithImage(MultipartFile file, String entity) throws IOException;
   public void uploadAlbumWithImage(MultipartFile file, Album entity) throws IOException;

}
