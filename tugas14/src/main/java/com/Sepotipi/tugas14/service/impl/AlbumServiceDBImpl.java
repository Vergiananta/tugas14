package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Album;
import com.Sepotipi.tugas14.entity.Artist;
import com.Sepotipi.tugas14.repository.AlbumRepository;
import com.Sepotipi.tugas14.service.AlbumService;
import com.Sepotipi.tugas14.util.FileUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;

@Service
public class AlbumServiceDBImpl implements AlbumService {
   @Autowired
   AlbumRepository albumRepository;

    @Autowired
    FileUtility fileUtil;

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
    public Album saveAlbumWithImage(MultipartFile file, String image) throws IOException {
        Album album = saveAlbum(objectMapper.readValue(image, Album.class));
        File uploade = new File("/home/melvian/Materi/week-9/tugas14/tugas14/images/Album Photos/" + album.getId() + ".png");
        file.transferTo(uploade);
        album.setImage(uploade.getPath());
        return albumRepository.save(album);
    }

    @Override
    public void uploadAlbumWithImage(MultipartFile file, Album entity) throws IOException {
        try {

            albumRepository.save(entity);
            String destination = String.format("album%s.%s", entity.getId().replaceAll("-", ""),
                    FilenameUtils.getExtension(file.getOriginalFilename()));

            String path = fileUtil.store(file, destination);
            System.out.println(path);

            entity.setImage(path);
            albumRepository.save(entity);
        } catch (IOException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something Happened During File Upload Process.");
        }
    }
    }

