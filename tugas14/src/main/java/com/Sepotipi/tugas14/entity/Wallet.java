package com.Sepotipi.tugas14.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mst_wallet")
public class Wallet {

    @Id
    @GeneratedValue(generator = "id_wallet", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "id_wallet", strategy = "uuid")
    private String id;

    private Double balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties(value = {"wallet"})
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    @JsonIgnoreProperties(value = {"wallet"})
    private List<Transaction> transaction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    @JsonIgnoreProperties(value = {"wallet"})
    private List<History> histories;

    public Wallet() {
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }
}
