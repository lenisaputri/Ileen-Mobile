package com.example.ileen_mobile.animal;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GambarFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvAnimal;
    //instansiasi list superhero
    private AnimalAdapter animalAdapter;
    List<Animal> listAnimal = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_gambar, container, false);
        rvAnimal = rootView.findViewById(R.id.rvAnimal);

        Animal animal = new Animal(this.getResources().getDrawable(R.drawable.camel));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.canary));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.cat));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.chicken));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.cow));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.dog));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.donkey));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.dove));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.duck));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.goat));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.goldfish));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.goose));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.marmut));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.hamster));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.pig));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.pigeon));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.rabbit));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.sheep));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.turkey));
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.turtle));
        listAnimal.add(animal);
        AnimalAdapter animalAdapter = new AnimalAdapter(listAnimal);
        rvAnimal.setAdapter(animalAdapter);

        rvAnimal.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }
}
