package com.example.ileen_mobile.animal;

import android.graphics.drawable.Drawable;

public class Animal {
    public String bind;
    public String bing;
    public Drawable image;

    public Animal(Drawable image,String bind, String bing)
    {
        this.bind = bind;
        this.bing = bing;
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public String getBing() {
        return bing;
    }

    public void setBing(String bing) {
        this.bing = bing;
    }
}
