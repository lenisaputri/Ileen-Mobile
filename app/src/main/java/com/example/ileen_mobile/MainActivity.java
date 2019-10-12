package com.example.ileen_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.ileen_mobile.animal.AnimalActivity;
import com.example.ileen_mobile.hobbies.HobbiesActivity;
import com.example.ileen_mobile.login.InputNamaActivity;
import com.example.ileen_mobile.login.PlayActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }

    public void animalHandler(View view) {
        Intent intent =  new Intent(this, AnimalActivity.class);
        startActivity(intent);
    }

    public void hobbiesHandler(View view){
        Intent intent =  new Intent(this, HobbiesActivity.class);
        startActivity(intent);
    }
}
