package com.example.ileen_mobile.transportation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ileen_mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TransportationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        openFragment(new MateriTransportationFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_materi:
                openFragment(new MateriTransportationFragment());
                return true;
            case R.id.action_gambar:
                openFragment(new GambarTransportationFragment());
                return true;
        }
        return false;
    }

    private void openFragment(Fragment fragment) {
        openFragment(fragment, false);
    }

    private void openFragment(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        if (addToBackstack)
            transaction.addToBackStack(null);
        transaction.commit();
    }
}
