package com.example.javafxproject.data.models;

public class Book {
    public int id;
    public String name;
    public int quality;
    public float price;
    public String typebook;
    public String image;

    public Book(int id, String name, int quality,float price, String typebook, String image) {
        this.id = id;
        this.name = name;
        this.quality = quality;
        this.price = price;
        this.typebook = typebook;
        this.image = image;

    }

    public Book(String name, int quality, float price, String typebook, String image) {
        this.name = name;
        this.price = price;
        this.quality = quality;
        this.typebook = typebook;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int name) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public float getPrice() {return price;}

    public void setPrice(float price) {
        this.price = price;
    }
    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getTypeBook() {
        return typebook;
    }

    public void setTypebook(String typebook) {
        this.typebook = typebook;
    }

}

