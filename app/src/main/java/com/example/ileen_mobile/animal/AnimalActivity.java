package com.example.ileen_mobile.animal;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.ileen_mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class AnimalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    //instansiasi Recyclerview
    RecyclerView rvAnimal;
    //instansiasi list superhero
    List<Animal> listAnimal = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        loadFragment(new MateriFragment());
        // Required empty public constructor

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        rvAnimal = findViewById(R.id.rvAnimal);
        Animal animal = new Animal(this.getResources().getDrawable(R.drawable.alpukat),"Alpukat");
        listAnimal.add(animal);
        AnimalAdapter buahAdapter = new AnimalAdapter(listAnimal);
        rvAnimal.setAdapter(buahAdapter);
        rvAnimal.setLayoutManager(new GridLayoutManager(this, 2));
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
