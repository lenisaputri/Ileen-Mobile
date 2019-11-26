package com.example.ileen_mobile.weather;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class WeatherMateri {
    public String isi;
    public String judul;

    public WeatherMateri() {
    }

    public WeatherMateri(String isi, String judul) {

        this.isi = isi;
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public String getJudul() {
        return judul;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("isi", isi);
        result.put("judul", judul);
        return result;
    }
}
