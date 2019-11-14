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

        Animal animal = new Animal(this.getResources().getDrawable(R.drawable.camel),"Unta","Camel");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.canary),"Burung Kenari","Canary");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.cat),"Kucing","Cat");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.chicken),"Ayam","Chicken");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.cow),"Sapi","Cow");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.dog),"Anjing","Dog");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.donkey),"Keledai","Donkey");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.dove),"Burung Merpati","Dove");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.duck),"Bebek","Duck");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.goat),"Kambing","Goat");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.goldfish),"Ikan Mas","Goldfish");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.goose),"Angsa","Goose");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.marmut),"Marmut","Guinea Pig");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.hamster),"Hamster","Hamster");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.pig),"Babi","Pig");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.pigeon),"Burung Dara","Pigeon");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.rabbit),"Kelinci","Rabbit");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.sheep),"Domba","Sheep");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.turkey),"Ayam Kalkun","Turkey");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.turtle),"Kura-kura","Turtle");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.koi),"Ikan Koi","Koi");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.template_1),"","");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.template_1),"","");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.template_1),"","");
        listAnimal.add(animal);
        animal = new Animal(this.getResources().getDrawable(R.drawable.template_1),"","");
        listAnimal.add(animal);
        AnimalAdapter animalAdapter = new AnimalAdapter(listAnimal);
        rvAnimal.setAdapter(animalAdapter);

        rvAnimal.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }
}
