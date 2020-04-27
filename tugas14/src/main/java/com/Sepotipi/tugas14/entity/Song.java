package com.Sepotipi.tugas14.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "mst_song")
public class Song {

    @Id
    @GeneratedValue(generator = "song_uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "song_uuid", strategy = "uuid")
    private String id;
    private String title;
    private Integer releaseYear;
    private Integer duration;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonIgnoreProperties("songs")
    public Genre genre;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    @JsonIgnoreProperties("songs")
    public Artist artist;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonIgnoreProperties("songs")
    private Album album;

//    @Transient
//    private String albumID;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "mst_song_has_playlist",joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "playlist_id")})
    public List<Playlist>playlists=new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    public List<Transaction> transactions = new ArrayList<>();

    public Song() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

//    public String getAlbumID() {
//        return albumID;
//    }
//
//    public void setAlbumID(String albumID) {
//        this.albumID = albumID;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return releaseYear == song.releaseYear &&
                duration == song.duration &&
                Objects.equals(id, song.id) &&
                Objects.equals(title, song.title) &&
                Objects.equals(price, song.price) &&
                Objects.equals(genre, song.genre) &&
                Objects.equals(artist, song.artist) &&
                Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, releaseYear, duration, price, genre, artist, album);
    }

}
