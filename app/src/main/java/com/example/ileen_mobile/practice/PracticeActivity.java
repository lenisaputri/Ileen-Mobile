package com.example.ileen_mobile.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;
import com.example.ileen_mobile.weather.WeatherActivity;

public class PracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
    }

    public void oneHandler(View view) {
        Intent intent =  new Intent(this, OneActivity.class);
        startActivity(intent);
    }
}
