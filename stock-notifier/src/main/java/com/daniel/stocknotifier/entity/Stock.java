package com.daniel.stocknotifier.entity;

public class Stock {
    public Integer id;
    public String name;

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
