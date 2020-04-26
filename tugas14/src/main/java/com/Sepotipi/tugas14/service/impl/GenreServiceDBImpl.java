package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Genre;
import com.Sepotipi.tugas14.repository.GenreRepository;
import com.Sepotipi.tugas14.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceDBImpl implements GenreService {
    @Autowired
    GenreRepository genreRepository;

    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Genre getGenreById(Integer id) {
        Genre genre = genreRepository.findById(id).get();
        return genre;
    }

    @Override
    public void deleteGenre(Integer id) {

        genreRepository.deleteById(id);
    }

    @Override
    public Page<Genre> searchGenre(Genre genre, Pageable pageable) {
       Page<Genre> genres= genreRepository.findAllByNameContains(genre.getName(), pageable);
        return genres;
    }

}
