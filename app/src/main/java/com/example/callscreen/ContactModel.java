package com.example.callscreen;

public class ContactModel {
    String name;
    int image;

    public ContactModel(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
