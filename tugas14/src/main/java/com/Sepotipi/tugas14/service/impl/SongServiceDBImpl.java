package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Profile;
import com.Sepotipi.tugas14.entity.Song;
import com.Sepotipi.tugas14.exception.ResourceNotFoundException;
import com.Sepotipi.tugas14.repository.SongRepository;
import com.Sepotipi.tugas14.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongServiceDBImpl implements SongService {

    @Autowired
    SongRepository songRepository;

    @Override
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song getSongById(String id) {
        Song song;
        if( songRepository.findById(id).isPresent()) {
            song = songRepository.findById(id).get();
        }  else throw new ResourceNotFoundException(id, Profile.class);
        return song;


//        song.setAlbumID(song.getAlbum().getId());
//        song = songRepository.findById(id).get();

    }

    @Override
    public void deleteSong(String id) {

        songRepository.deleteById(id);
    }

    @Override
    public Page<Song> searchSong(Song song, Pageable pageable) {

      Page<Song>songs = songRepository.findAllByTitleContains(song.getTitle(), pageable);
        return songs;
    }
}
