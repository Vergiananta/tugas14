package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Album;
import com.Sepotipi.tugas14.entity.Artist;
import com.Sepotipi.tugas14.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/{id}")
    public Album getSongById(@PathVariable String id){
        return albumService.getAlbumById(id);
    }

    @DeleteMapping
    public void deleteAlbum(@RequestBody Album album){
        albumService.deleteAlbum(album.getId());
    }

    @PostMapping
    public void saveAlbum(@RequestBody Album album){
        albumService.saveAlbum(album);
    }


    @GetMapping("/search")
    public Page<Album> searchByName(@RequestBody Album searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return albumService.searchAlbum(searchForm, pageable);
    }
    @PostMapping("/img/upload")
    public Album saveAlbumContaintImage(@RequestPart MultipartFile file, @RequestPart String photo) throws IOException {

        return albumService.saveAlbumWithImage(file,photo);

    }

}
