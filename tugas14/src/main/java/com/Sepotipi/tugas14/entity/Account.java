package com.Sepotipi.tugas14.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mst_account")
public class Account {

    @Id
    @GeneratedValue(generator = "id_account", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "id_account", strategy = "uuid")
    private String id;

    @JsonProperty
    private Boolean isActive;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    @JsonIgnoreProperties(value = {"account"})
    private Wallet wallet;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"account"})
    private Profile profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    @JsonIgnoreProperties(value = {"account"})
    private List<Playlist> playlist;

    public Account() {
    }

    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(isActive, account.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive);
    }
}
