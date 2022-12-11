package com.book.entity;

public class book {
    private int bid;
    private String name;
    private  int price;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public book(int bid) {
        this.bid = bid;
    }

    public book() {
    }
}
