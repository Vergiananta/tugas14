package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Album;
import com.Sepotipi.tugas14.repository.AlbumRepository;
import com.Sepotipi.tugas14.service.AlbumService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AlbumServiceDBImpl implements AlbumService {
   @Autowired
   AlbumRepository albumRepository;

   @Autowired
    ObjectMapper objectMapper;

    @Override
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public Album getAlbumById(String id) {
        Album album = albumRepository.findById(id).get();
        return album;
    }

    @Override
    public void deleteAlbum(String id) {
        albumRepository.deleteById(id);
    }

    @Override
    public Page<Album> searchAlbum(Album album, Pageable pageable) {
        Page<Album>albums = albumRepository.findAllByTitleContainsAndDescriptionContains(album.getTitle(), album.getDescription(), pageable);

        return albums;
    }

    @Override
    public Album saveAlbumWithImage(MultipartFile file, String entity) throws IOException {
        Album album = saveAlbum(objectMapper.readValue(entity, Album.class));
        File uploade = new File("/home/melvian/Materi/week-9/tugas14/images/Album Photos/" + album.getId() + ".png");
        file.transferTo(uploade);
        album.setImage(uploade.getPath());
        return albumRepository.save(album);
    }
}
