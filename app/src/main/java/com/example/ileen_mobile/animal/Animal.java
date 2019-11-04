package com.example.ileen_mobile.animal;

import android.graphics.drawable.Drawable;

public class Animal {
//    public String judul;
    public Drawable image;

    public Animal(Drawable image)
    {
//        this.judul = judul;
        this.image = image;
    }

//    public String getJudul() {
//        return judul;
//    }
//
//    public void setJudul(String judul) {
//        this.judul = judul;
//    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
