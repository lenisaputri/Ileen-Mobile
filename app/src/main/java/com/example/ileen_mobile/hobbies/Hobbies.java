package com.example.ileen_mobile.hobbies;

import android.graphics.drawable.Drawable;

public class Hobbies {
    public String bind;
    public String bing;
    public Drawable image;

    public Hobbies(String bind, String bing, Drawable image) {
        this.bind = bind;
        this.bing = bing;
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

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
