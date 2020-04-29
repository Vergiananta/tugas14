package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Artist;
import com.Sepotipi.tugas14.entity.Song;
import com.Sepotipi.tugas14.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongService songService;

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable String id){
        return songService.getSongById(id);
    }

    @DeleteMapping
    public void deleteSong(@RequestBody Song song){
        songService.deleteSong(song.getId());
    }

    @PostMapping
    public void saveSong(@RequestBody Song song){
        songService.saveSong(song);
    }

    @GetMapping("/search")
    public Page<Song> searchByName(@RequestBody Song searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return songService.searchSong(searchForm, pageable);
    }

    @GetMapping("/search-artist")
    public Page<Song> searchByArtist(@RequestBody Song searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return songService.searchByArtist(searchForm, pageable);
    }
    @GetMapping("/search-album")
    public Page<Song> searchByAlbum(@RequestBody Song searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return songService.searchByAlbum(searchForm, pageable);
    }
    @GetMapping("/search-genre")
    public Page<Song> searchByGenre(@RequestBody Song searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return songService.searchByGenre(searchForm, pageable);
    }
}
