package com.daniel.stocknotifier.entity;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String companyName;
    @Column(unique = true, nullable = false)
    private String ticker;


    public Stock(Integer id, String companyName, String ticker) {
        this.id = id;
        this.companyName = companyName;
        this.ticker = ticker;
    }

    public Stock() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", ticker='" + ticker + '\'' +
                '}';
    }
}
