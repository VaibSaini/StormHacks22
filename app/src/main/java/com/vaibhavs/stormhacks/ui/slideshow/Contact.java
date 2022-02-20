package com.vaibhavs.stormhacks.ui.slideshow;

public class Contact {
    private String name;
    private int image;
    private String email;
    private String number;

    public Contact(String name, int image, String email, String number) {
        this.name = name;
        this.image = image;
        this.email = email;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }
}
