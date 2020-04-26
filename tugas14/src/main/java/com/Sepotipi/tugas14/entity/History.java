package com.Sepotipi.tugas14.entity;

import com.Sepotipi.tugas14.enums.HistoryTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "mst_wallet_history")
public class History {

    @Id
    @GeneratedValue(generator = "id_history", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "id_history", strategy = "uuid")
    private String id;

    @Enumerated(EnumType.STRING)
    private HistoryTypeEnum type;

    private Double amount;

    @Column(name = "trx_date")
    private Timestamp trxDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    @JsonIgnoreProperties(value = {"histories"})
    private Wallet wallet;

    public History() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HistoryTypeEnum getType() {
        return type;
    }

    public void setType(HistoryTypeEnum type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Timestamp trxDate) {
        this.trxDate = trxDate;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(id, history.id) &&
                type == history.type &&
                Objects.equals(amount, history.amount) &&
                Objects.equals(trxDate, history.trxDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, trxDate);
    }
}
