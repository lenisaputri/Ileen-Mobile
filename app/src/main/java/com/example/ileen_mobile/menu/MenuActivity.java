package com.example.ileen_mobile.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ileen_mobile.MainActivity;
import com.example.ileen_mobile.R;
import com.example.ileen_mobile.animal.AnimalActivity;
import com.example.ileen_mobile.clock.ClockActivity;
import com.example.ileen_mobile.conversation.ConversationActivity;
import com.example.ileen_mobile.food.FoodActivity;
import com.example.ileen_mobile.hobbies.HobbiesActivity;
import com.example.ileen_mobile.login.PlayActivity;
import com.example.ileen_mobile.number.NumberActivity;
import com.example.ileen_mobile.practice.PracticeActivity;
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
//    private Button btnNext, btnLeft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        viewPager = findViewById(R.id.view_pager);
        dotsLayout = findViewById(R.id.layoutDots);
//        btnNext = findViewById(R.id.btn_next);
//        btnLeft = findViewById(R.id.btn_left);
        layouts = new int[]{
                R.layout.menu_slide1,
                R.layout.menu_slide2};

        addBottomDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
//        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // checking for last page
//                // if last page home screen will be launched
//                int current = getItem(+1);
//                if (current < layouts.length) {
//                    // move to next screen
//                    viewPager.setCurrentItem(current);
//                }
//            }
//        });
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

//    //  viewpager change listener
//    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
//
//        @Override
//        public void onPageSelected(int position) {
//            // changing the next button text 'NEXT' / 'GOT IT'
//            if (position == layouts.length - 1) {
//                // last page. make button text to GOT IT
//                btnLeft.setText("LEFT");
//                btnNext.setVisibility(View.GONE);
//            } else {
//                // still pages are left
//                btnNext.setText("NEXT");
//                btnLeft.setVisibility(View.GONE);
//            }
//        }
//
//        @Override
//        public void onPageScrolled(int arg0, float arg1, int arg2) {
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int arg0) {
//
//        }
//    };

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

        Intent intent =  new Intent(this, AnimalActivity.class);
        startActivity(intent);
    }

    public void clockHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.clock);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, ClockActivity.class);
        startActivity(intent);
    }

    public void conversationHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.conversation);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, ConversationActivity.class);
        startActivity(intent);
    }

    public void foodHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.food);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, FoodActivity.class);
        startActivity(intent);
    }

    public void hobbiesHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.hobbies);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, HobbiesActivity.class);
        startActivity(intent);
    }

    public void numberHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.number);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, NumberActivity.class);
        startActivity(intent);
    }

    public void sportsHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.sports);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, SportActivity.class);
        startActivity(intent);
    }

    public void transportationHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.transportation);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, TransportationActivity.class);
        startActivity(intent);
    }

    public void weatherHandler(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.weather);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);

        Intent intent =  new Intent(this, WeatherActivity.class);
        startActivity(intent);
    }

//    public void practiceHandler(View view) {
//        ImageButton button = (ImageButton)findViewById(R.id.practice);
//        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
//
//        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
//        myAnim.setInterpolator(interpolator);
//
//        button.startAnimation(myAnim);
//
//        Intent intent =  new Intent(this, PracticeActivity.class);
//        startActivity(intent);
//    }

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
