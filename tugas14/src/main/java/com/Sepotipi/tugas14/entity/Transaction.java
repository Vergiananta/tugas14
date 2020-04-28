package com.Sepotipi.tugas14.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mst_transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "song_uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "song_uuid", strategy = "uuid")
    private String id;
    private Timestamp trxDate;
    private Double amount;
    @Column(name = "album_discount")
    private Double albumDiscount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id")
    @JsonIgnoreProperties(value = {"transaction"})
    public Song item;

    @Transient
    public String albumId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wallet_id",nullable = false)
    @JsonIgnoreProperties(value = {"transaction"})
    private Wallet wallet;


    public Transaction() {
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Timestamp trxDate) {
        this.trxDate = trxDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAlbumDiscount() {
        return albumDiscount;
    }

    public void setAlbumDiscount(Double albumDiscount) {
        this.albumDiscount = albumDiscount;
    }

    public Song getItem() {
        return item;
    }

    public void setItem(Song item) {
        this.item = item;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", trxDate=" + trxDate +
                ", amount=" + amount +
                ", albumDiscount=" + albumDiscount +
                ", item=" + item +
                '}';
    }
}
