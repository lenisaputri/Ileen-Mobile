package com.example.ileen_mobile.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ileen_mobile.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel = (TextView) findViewById(R.id.resultLabel);
        TextView totalScoreLabel = (TextView) findViewById(R.id.totalScoreLabel);


        int score = getIntent().getIntExtra("JAWABAN_BENAR_LABEL", 0);

        SharedPreferences setting = getSharedPreferences("ILEN", Context.MODE_PRIVATE);
        int totalScore = setting.getInt("totalScore", 0);
        totalScore = score;



        resultLabel.setText(score + " / 10");
        totalScoreLabel.setText("Total Score : " + totalScore);

        SharedPreferences.Editor editor = setting.edit();
        editor.putInt("totalScore", totalScore);
        editor.commit();


    }

    public void exitTop(View view) {
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }
}
