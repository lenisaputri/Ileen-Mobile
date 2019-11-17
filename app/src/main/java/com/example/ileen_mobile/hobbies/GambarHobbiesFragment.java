package com.example.ileen_mobile.hobbies;


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
public class GambarHobbiesFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvHobbies;
    //instansiasi list superhero
    private HobbiesAdapter hobbiesAdapter;
    List<Hobbies> listHobbies = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarHobbiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gambar_hobbies, container, false);
        rvHobbies = rootView.findViewById(R.id.rvHobbies);

        Hobbies hobbies = new Hobbies("Bersepeda","Cycling",this.getResources().getDrawable(R.drawable.cycling));
        listHobbies.add(hobbies);
        hobbies = new Hobbies("Bermain Sepakbola","Playing Football",this.getResources().getDrawable(R.drawable.football));
        listHobbies.add(hobbies);
        hobbies = new Hobbies("Mendaki","Hiking",this.getResources().getDrawable(R.drawable.hiking));
        listHobbies.add(hobbies);
        hobbies = new Hobbies("Berselancar","Surfing",this.getResources().getDrawable(R.drawable.surfing));
        listHobbies.add(hobbies);
        hobbies = new Hobbies("Bermain Tenis","Playing Tennis",this.getResources().getDrawable(R.drawable.tennis));
        listHobbies.add(hobbies);
        hobbies = new Hobbies("Bermain Bola Voli","Playing Volleyball",this.getResources().getDrawable(R.drawable.volleyball));
        listHobbies.add(hobbies);

        HobbiesAdapter hobbiesAdapter = new HobbiesAdapter(listHobbies);
        rvHobbies.setAdapter(hobbiesAdapter);

        rvHobbies.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }

}
