package com.Sepotipi.tugas14.entity;

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
    private Double albumDiscount;

    @ManyToOne
    @JoinColumn(name = "song_id")
    public Song item;

//    private Wallet wallet;


    public Transaction() {
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
