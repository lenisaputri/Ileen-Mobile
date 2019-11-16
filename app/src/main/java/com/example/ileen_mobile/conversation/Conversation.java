package com.example.ileen_mobile.conversation;

public class Conversation {
    public String isi_conversation;

    public Conversation() {
    }

    public Conversation(String isi_conversation) {

        this.isi_conversation = isi_conversation;
    }

    public String getIsi_conversation() {
        return isi_conversation;
    }

    public void setIsi_conversation(String isi_conversation) {
        this.isi_conversation = isi_conversation;
    }

    //
//    @Exclude
//    public Map<String, Object> toMap() {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("isi", isi);
//        return result;
//    }
}
