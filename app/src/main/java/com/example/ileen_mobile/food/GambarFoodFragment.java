package com.example.ileen_mobile.food;


import android.media.MediaPlayer;
import android.os.Bundle;

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
public class GambarFoodFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvFood;
    //instansiasi list superhero
    private FoodAdapter foodAdapter;
    List<Food> listFood = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gambar_food, container, false);
        rvFood = rootView.findViewById(R.id.rvFood);

        Food food = new Food("Roti","Bread",this.getResources().getDrawable(R.drawable.bread));
        listFood.add(food);
        food = new Food("Kue Kering","Cookies",this.getResources().getDrawable(R.drawable.cookies));
        listFood.add(food);
        food = new Food("Telur","Egg",this.getResources().getDrawable(R.drawable.egg));
        listFood.add(food);
        food = new Food("Nasi Goreng","Friedrice",this.getResources().getDrawable(R.drawable.friedrice));
        listFood.add(food);
        food = new Food("Kue Mufin","Muffin",this.getResources().getDrawable(R.drawable.muffin));
        listFood.add(food);
        food = new Food("Pizza","Pizza",this.getResources().getDrawable(R.drawable.pizza));
        listFood.add(food);
        food = new Food("Berondong Jagung","Popcorn",this.getResources().getDrawable(R.drawable.popcorn));
        listFood.add(food);
        food = new Food("Nasi","Rice",this.getResources().getDrawable(R.drawable.rice));
        listFood.add(food);
        food = new Food("Burger","Burger",this.getResources().getDrawable(R.drawable.burger));
        listFood.add(food);
        food = new Food("Kue","Cake",this.getResources().getDrawable(R.drawable.cake));
        listFood.add(food);
        food = new Food("Permen","Candy",this.getResources().getDrawable(R.drawable.candy));
        listFood.add(food);
        food = new Food("Es Krim","Ice Cream",this.getResources().getDrawable(R.drawable.ice));
        listFood.add(food);
        food = new Food("Sup","Soup",this.getResources().getDrawable(R.drawable.soup));
        listFood.add(food);
        food = new Food("Selai","Jam",this.getResources().getDrawable(R.drawable.jam));
        listFood.add(food);
        food = new Food("Roti Isi","Sandwich",this.getResources().getDrawable(R.drawable.sandwich));
        listFood.add(food);
        food = new Food("","",this.getResources().getDrawable(R.drawable.template_1));
        listFood.add(food);
        food = new Food("","",this.getResources().getDrawable(R.drawable.template_1));
        listFood.add(food);
        food = new Food("","",this.getResources().getDrawable(R.drawable.template_1));
        listFood.add(food);
        food = new Food("","",this.getResources().getDrawable(R.drawable.template_1));
        listFood.add(food);

        FoodAdapter foodAdapter = new FoodAdapter(listFood);
        rvFood.setAdapter(foodAdapter);

        rvFood.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }

}
