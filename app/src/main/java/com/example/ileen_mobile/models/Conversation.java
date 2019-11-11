package com.example.ileen_mobile.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Conversation {
    public String isi_conversation;

    public Conversation() {
    }

    public Conversation(String isi_conversation) {
        this.isi_conversation = isi_conversation;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("isi_conversation", isi_conversation);
        return result;
    }
}
