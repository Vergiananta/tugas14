package com.Sepotipi.tugas14.service;

import com.Sepotipi.tugas14.entity.Playlist;
import com.Sepotipi.tugas14.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PlaylistService {

    public Playlist savePlaylist(Playlist playlist);
    public Playlist getPlaylistById (String id);
    public void deletePlaylist(String id);

}
