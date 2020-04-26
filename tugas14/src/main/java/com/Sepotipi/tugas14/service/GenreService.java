package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenreService {

    public Genre saveGenre(Genre genre);
    public Genre getGenreById (Integer id);
    public void deleteGenre(Integer id);
    public Page<Genre> searchGenre(Genre genre, Pageable pageable);
}
