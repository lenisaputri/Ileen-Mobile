package com.example.ileen_mobile.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ileen_mobile.R;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }

    public void playButton(View view) {
        Intent intent =  new Intent(PlayActivity.this, InputNamaActivity.class);
        startActivity(intent);
    }
}
