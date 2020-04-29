package com.Sepotipi.tugas14.controller;

import com.Sepotipi.tugas14.entity.Playlist;
import com.Sepotipi.tugas14.entity.Song;
import com.Sepotipi.tugas14.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable String id){
        return playlistService.getPlaylistById(id);
    }

    @DeleteMapping
    public void deletePlaylist(@RequestBody Playlist playlist){
        playlistService.deletePlaylist(playlist.getId());
    }

    @PostMapping
    public void savePlaylist(@RequestBody Playlist playlist){
        playlistService.savePlaylist(playlist);
    }
}
