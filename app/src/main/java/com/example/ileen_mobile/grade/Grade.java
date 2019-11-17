package com.example.ileen_mobile.grade;

import android.graphics.drawable.Drawable;

public class Grade {
    Drawable level;
    String nilai;
    String soal;

    public Grade(Drawable level, String nilai, String soal) {
        this.level = level;
        this.nilai = nilai;
        this.soal = soal;
    }

    public Drawable getLevel() {
        return level;
    }

    public void setLevel(Drawable level) {
        this.level = level;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }
}
