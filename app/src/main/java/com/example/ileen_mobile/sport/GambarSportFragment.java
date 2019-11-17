package com.example.ileen_mobile.sport;


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
public class GambarSportFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvSport;
    //instansiasi list superhero
    private SportAdapter sportAdapter;
    List<Sport> listSport = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarSportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gambar_sport, container, false);
        rvSport = rootView.findViewById(R.id.rvSport);

        Sport sport = new Sport("Catur","Chess",this.getResources().getDrawable(R.drawable.catur));
        listSport.add(sport);
        sport = new Sport("Lempar Cakram","Discus",this.getResources().getDrawable(R.drawable.discus));
        listSport.add(sport);
        sport = new Sport("Sepak Bola","Football",this.getResources().getDrawable(R.drawable.football));
        listSport.add(sport);
        sport = new Sport("Olahraga Senam","Gymnastic",this.getResources().getDrawable(R.drawable.gymnastic));
        listSport.add(sport);
        sport = new Sport("Berkuda","Horse Riding",this.getResources().getDrawable(R.drawable.horseriding));
        listSport.add(sport);
        sport = new Sport("Balap Mobil","Motorsport",this.getResources().getDrawable(R.drawable.motorsport));
        listSport.add(sport);
        sport = new Sport("Olahraga Lari","Running",this.getResources().getDrawable(R.drawable.running));
        listSport.add(sport);
        sport = new Sport("Berlayar","Sailing",this.getResources().getDrawable(R.drawable.sailing));
        listSport.add(sport);
        sport = new Sport("Bersepeda","Cycling",this.getResources().getDrawable(R.drawable.cycling));
        listSport.add(sport);
        sport = new Sport("Ski","Skiing",this.getResources().getDrawable(R.drawable.ski));
        listSport.add(sport);
        sport = new Sport("Berselancar","Surfing",this.getResources().getDrawable(R.drawable.surfing));
        listSport.add(sport);
        sport = new Sport("Bola Voli","Volley Ball",this.getResources().getDrawable(R.drawable.volleyball));
        listSport.add(sport);
        sport = new Sport("Bola Basket","Basket Ball",this.getResources().getDrawable(R.drawable.basket));
        listSport.add(sport);
        sport = new Sport("Panahan","Archery",this.getResources().getDrawable(R.drawable.archery));
        listSport.add(sport);
        sport = new Sport("Karate","Karate",this.getResources().getDrawable(R.drawable.karate));
        listSport.add(sport);
        sport = new Sport("","",this.getResources().getDrawable(R.drawable.template_1));
        listSport.add(sport);
        sport = new Sport("","",this.getResources().getDrawable(R.drawable.template_1));
        listSport.add(sport);
        sport = new Sport("","",this.getResources().getDrawable(R.drawable.template_1));
        listSport.add(sport);
        sport = new Sport("","",this.getResources().getDrawable(R.drawable.template_1));
        listSport.add(sport);

        SportAdapter sportAdapter = new SportAdapter(listSport);
        rvSport.setAdapter(sportAdapter);

        rvSport.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }

}
