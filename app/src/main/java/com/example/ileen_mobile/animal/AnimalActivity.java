package com.example.ileen_mobile.animal;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.ileen_mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AnimalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private ViewPager viewPager;
    private MyPager myPager;
    int images[] = {R.drawable.animal_menu, R.drawable.clock_menu, R.drawable.conversation_menu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        loadFragment(new MateriFragment());
        // Required empty public constructor

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        viewPager = findViewById(R.id.view_pager);
        myPager = new MyPager(AnimalActivity.this, images);
//        viewPager.setAdapter(myPager);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_materi:
                fragment = new MateriFragment();
                break;
            case R.id.action_gambar:
                fragment = new GambarFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
