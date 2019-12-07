package com.example.ileen_mobile.menu;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ileen_mobile.R;
import com.example.ileen_mobile.animal.AnimalActivity;
import com.example.ileen_mobile.clock.ClockActivity;
import com.example.ileen_mobile.conversation.ConversationActivity;
import com.example.ileen_mobile.food.FoodActivity;
import com.example.ileen_mobile.hobbies.HobbiesActivity;
import com.example.ileen_mobile.number.NumberActivity;
import com.example.ileen_mobile.sport.SportActivity;
import com.example.ileen_mobile.transportation.TransportationActivity;
import com.example.ileen_mobile.weather.WeatherActivity;

public class MenuActivity extends AppCompatActivity {

    /**
     * Slide menu
     */

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        viewPager = findViewById(R.id.view_pager);
        dotsLayout = findViewById(R.id.layoutDots);
        layouts = new int[]{
                R.layout.menu_slide1,
                R.layout.menu_slide2};

        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    /**
     * Handler Menu
     */

    public void animalHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.animal);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, AnimalActivity.class);
        startActivity(intent);
    }

    public void clockHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.clock);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, ClockActivity.class);
        startActivity(intent);
    }

    public void conversationHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.conversation);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, ConversationActivity.class);
        startActivity(intent);
    }

    public void foodHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.food);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, FoodActivity.class);
        startActivity(intent);
    }

    public void hobbiesHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.hobbies);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, HobbiesActivity.class);
        startActivity(intent);
    }

    public void numberHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.number);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, NumberActivity.class);
        startActivity(intent);
    }

    public void sportsHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.sports);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, SportActivity.class);
        startActivity(intent);
    }

    public void transportationHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.transportation);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, TransportationActivity.class);
        startActivity(intent);
    }

    public void weatherHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.weather);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        MediaPlayer mp = MediaPlayer.create(MenuActivity.this, R.raw.click_btn);
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.release();
            }

        });
        mp.start();

        Intent intent =  new Intent(this, WeatherActivity.class);
        startActivity(intent);
    }

    /**
     * Animation button
     */

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
