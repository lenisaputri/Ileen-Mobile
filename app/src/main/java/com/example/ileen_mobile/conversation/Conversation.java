package com.example.ileen_mobile.conversation;

import android.graphics.drawable.Drawable;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Conversation {
    public String bind;
    public String bing;
    public String image_url;
    public String audio_url;

    public Conversation(){

    }

    public Conversation(String image_url,String bind, String bing, String audio_url)
    {
        this.bind = bind;
        this.bing = bing;
        this.image_url = image_url;
        this.audio_url = audio_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public String getAudio_url() {
        return audio_url;
    }

    public void setAudio_url(String audio_url) {
        this.audio_url = audio_url;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("bind", bind);
        result.put("bing", bing);
        result.put("image_url", image_url);
        result.put("audio_url", audio_url);
        return result;
    }
}
