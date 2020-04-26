package com.Sepotipi.tugas14.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_album")
public class Album {

    @Id
    @GeneratedValue(generator = "album_uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "album_uuid", strategy = "uuid")
    private String id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Double discount;
    private String image;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<Song> songs = new ArrayList<>();

    @Transient
    public int countSong;

    public Album() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public int getCountSong() {
        return songs.size();
    }

    public void setCountSong(int countSong) {
        this.countSong = countSong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return releaseYear == album.releaseYear &&
                Objects.equals(id, album.id) &&
                Objects.equals(title, album.title) &&
                Objects.equals(description, album.description) &&
                Objects.equals(discount, album.discount) &&
                Objects.equals(image, album.image) &&
                Objects.equals(songs, album.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, releaseYear, discount, image, songs);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", songs=" + songs +
                '}';
    }
}
