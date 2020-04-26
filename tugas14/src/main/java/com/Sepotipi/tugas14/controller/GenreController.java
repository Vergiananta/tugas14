package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Genre;
import com.Sepotipi.tugas14.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Integer id){
        return genreService.getGenreById(id);
    }

    @DeleteMapping
    public void deleteGenre(@RequestBody Genre genre){
        genreService.deleteGenre(genre.getId());
    }

    @PostMapping
    public void saveGenre(@RequestBody Genre genre){
        genreService.saveGenre(genre);
    }

    @GetMapping("/search")
    public Page<Genre> searchByName(@RequestBody Genre searchForm, @RequestParam(name = "page") Integer page, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return genreService.searchGenre(searchForm, pageable);
    }


}
