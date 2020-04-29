package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {

    public Song saveSong(Song song);
    public Song getSongById (String id);
    public void deleteSong(String id);
    public Page<Song> searchSong(Song song, Pageable pageable);
    public Page<Song> searchByArtist(Song song, Pageable pageable);
    public Page<Song> searchByAlbum(Song song, Pageable pageable);
    public Page<Song> searchByGenre(Song song, Pageable pageable);

}
