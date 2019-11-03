package com.example.ileen_mobile.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.ileen_mobile.HomeWatcher;
import com.example.ileen_mobile.MusicService;
import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;
import com.example.ileen_mobile.practice.PracticeActivity;

public class PlayActivity extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        myDialog = new Dialog(this);
//        playsound();

    }

//
//    private void playsound(){
//        try {
//            if(play.isPlaying()){
//                play.stop();
//                play.release();
//            }
//        } catch(Exception e){
//
//        }
//        play = MediaPlayer.create(this, R.raw.play);
//        play.setLooping(true);
//        play.start();
//    }

    public void playButton(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.button_play);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(PlayActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(PlayActivity.this, PracticeActivity.class);
        startActivity(intent);


    }

    public void studyButton(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.button_study);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(PlayActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(PlayActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    public void nameButton(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.button_name);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(PlayActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();
    }

    public void gradeButton(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.button_grade);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(PlayActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();
    }

    public void ShowPopup(View view) {
        ImageView close_icon;
        myDialog.setContentView(R.layout.setting_popup);
        close_icon =(ImageView) myDialog.findViewById(R.id.close_icon);
        close_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        MediaPlayer mp = MediaPlayer.create(PlayActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    class MyBounceInterpolator implements android.view.animation.Interpolator {
        private double mAmplitude = 1;
        private double mFrequency = 10;

        MyBounceInterpolator(double amplitude, double frequency) {
            mAmplitude = amplitude;
            mFrequency = frequency;
        }

        public float getInterpolation(float time) {
            return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                    Math.cos(mFrequency * time) + 1);
        }
    }
}
