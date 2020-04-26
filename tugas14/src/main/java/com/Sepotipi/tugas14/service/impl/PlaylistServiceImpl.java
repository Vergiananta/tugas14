package com.Sepotipi.tugas14.service.impl;

import com.Sepotipi.tugas14.entity.Playlist;
import com.Sepotipi.tugas14.repository.PlaylistRepository;
import com.Sepotipi.tugas14.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public Playlist savePlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist getPlaylistById(String id) {

        Playlist playlist = playlistRepository.findById(id).get();

        return playlist;
    }

    @Override
    public void deletePlaylist(String id) {

        playlistRepository.deleteById(id);
    }
}
