package com.example.ileen_mobile.clock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ileen_mobile.R;
import com.example.ileen_mobile.animal.GambarFragment;
import com.example.ileen_mobile.animal.MateriFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ClockActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        loadFragment(new MateriClockFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
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
                fragment = new MateriClockFragment();
                break;
            case R.id.action_gambar:
                fragment = new GambarClockFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
