package com.example.ileen_mobile.conversation;

import android.graphics.drawable.Drawable;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Conversation {
    public String topik;
    public Drawable dialog;

    public Conversation(String topik, Drawable dialog) {
        this.topik = topik;
        this.dialog = dialog;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public Drawable getDialog() {
        return dialog;
    }

    public void setDialog(Drawable dialog) {
        this.dialog = dialog;
    }

    public String isi;

    public Conversation() {
    }

    public Conversation(String isi) {

        this.isi = isi;
    }

    public String getIsi() {
        return isi;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("isi", isi);
        return result;
    }
}
