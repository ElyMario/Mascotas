package com.ely.mascotas;

import android.media.Image;

public class PetObject {

    private int image;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    private String likes;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public PetObject(String name, String likes, int image) {
        this.name = name;
        this.likes = likes;
        this.image = image;
    }
}
