package com.example.ileen_mobile.conversation;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Conversation {
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
