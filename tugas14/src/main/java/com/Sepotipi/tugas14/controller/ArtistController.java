package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Artist;
import com.Sepotipi.tugas14.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistService artistService;

    @Autowired
    ServletContext servletContext;



    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable String id){
        return artistService.getArtistById(id);
    }

    @DeleteMapping("/artist")
    public void deleteArtist(@RequestBody Artist artist){
        artistService.deleteArtist(artist.getId());
    }

    @PostMapping
    public void saveSong(@RequestBody Artist artist){
        artistService.saveArtist(artist);
    }


    @PostMapping("/img")
    public Artist saveArtistContaintImage(@RequestPart MultipartFile file, @RequestPart String photo) throws IOException {

        return artistService.saveArtistWithImage(file,photo);

    }
    @GetMapping("/search")
    public Page<Artist> searchByName(@RequestBody Artist searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return artistService.searchArtist(searchForm, pageable);
    }
}
