package com.example.demo1.entity;

public class BookEntity {
    private int id;
    private String name;
    private double price;
    private String author;

    public BookEntity(int id, String author, double price, String name) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.name = name;
    }

    public BookEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
