package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.service.ArtistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.Sepotipi.tugas14.entity.Artist;
import com.Sepotipi.tugas14.repository.ArtistRepository;
import com.Sepotipi.tugas14.util.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ArtistServiceDBImpl implements ArtistService {

    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    FileUtility fileUtil;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtistById(String id) {
      Artist artist = artistRepository.findById(id).get();
        return artist;
    }

    @Override
    public void deleteArtist(String id) {

        artistRepository.deleteById(id);
    }

    @Override
    public Page<Artist> searchArtist(Artist artist, Pageable pageable) {
        Page<Artist> artists = artistRepository.findAllByNameContains(artist.getName(), pageable);
        return artists;
    }

    @Override
    public Artist saveArtistWithImage(MultipartFile file, String image) throws IOException {
        Artist artist = saveArtist(objectMapper.readValue(image, Artist.class));
        File uploade = new File("/home/melvian/Materi/week-9/tugas14/images/Artist Photos/" + artist.getId() + ".png");
        file.transferTo(uploade);
        artist.setPhoto(uploade.getPath());
        return artistRepository.save(artist);
    }

//    @Override
//    public void saveArtistWithImage(MultipartFile file, Artist entity) throws IOException {
//       try {
//
//           artistRepository.save(entity);
//           String destination = String.format("artist%s.%s", entity.getId().replaceAll("-", ""),
//                   FilenameUtils.getExtension(file.getOriginalFilename()));
//
//           String path = fileUtil.store(file, destination);
//           System.out.println(path);
//
//           entity.setPhoto(path);
//           artistRepository.save(entity);
//       } catch (IOException e){
//           e.printStackTrace();
//           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something Happened During File Upload Process.");
//       }
//    }
}
