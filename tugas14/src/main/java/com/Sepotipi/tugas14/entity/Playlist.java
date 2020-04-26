package com.Sepotipi.tugas14.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mst_playlist")
public class Playlist {

    @Id
    @GeneratedValue(generator = "song_uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "song_uuid", strategy = "uuid")
    private String id;
    private String name;
    private Boolean isPublic;

    @ManyToMany(mappedBy = "playlists", cascade = CascadeType.ALL)
    public List<Song> songs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties(value = "playlist")
    public Account account;


    public Playlist() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
