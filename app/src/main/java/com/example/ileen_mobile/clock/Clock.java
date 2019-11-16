package com.example.ileen_mobile.clock;

import android.graphics.drawable.Drawable;

public class Clock {
    public String bind;
    public String bing;
    public Drawable image;

    public Clock(String bind, String bing, Drawable image) {
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
