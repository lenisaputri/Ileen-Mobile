package com.example.ileen_mobile.weather;


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
public class GambarWeatherFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvWeather;
    //instansiasi list superhero
    private WeatherAdapter weatherAdapter;
    List<Weather> listWeather = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gambar_weather, container, false);
        rvWeather = rootView.findViewById(R.id.rvWeather);

        Weather weather = new Weather("Awan","Cloud",this.getResources().getDrawable(R.drawable.cloud));
        listWeather.add(weather);
        weather = new Weather("Air Hujan","Raindrop",this.getResources().getDrawable(R.drawable.raindrop));
        listWeather.add(weather);
        weather = new Weather("Keping Salju","Snowflake",this.getResources().getDrawable(R.drawable.snowflake));
        listWeather.add(weather);
        weather = new Weather("Petir","Thunder",this.getResources().getDrawable(R.drawable.thunder));
        listWeather.add(weather);
        weather = new Weather("Angin Topan","Tornado",this.getResources().getDrawable(R.drawable.tornado));
        listWeather.add(weather);
        weather = new Weather("Matahari","Sun",this.getResources().getDrawable(R.drawable.sun));
        listWeather.add(weather);
        weather = new Weather("Bulan","Moon",this.getResources().getDrawable(R.drawable.moon));
        listWeather.add(weather);
        weather = new Weather("Panas","Hot",this.getResources().getDrawable(R.drawable.hot));
        listWeather.add(weather);
        weather = new Weather("Dingin","Cold",this.getResources().getDrawable(R.drawable.cold));
        listWeather.add(weather);
        weather = new Weather("Payung","Umbrella",this.getResources().getDrawable(R.drawable.umbrella));
        listWeather.add(weather);
        weather = new Weather("Topi","Hat",this.getResources().getDrawable(R.drawable.hat));
        listWeather.add(weather);
        weather = new Weather("Sarung Tangan","Glove",this.getResources().getDrawable(R.drawable.gloves));
        listWeather.add(weather);
        weather = new Weather("Jaket","Jacket",this.getResources().getDrawable(R.drawable.jacket));
        listWeather.add(weather);
        weather = new Weather("Sepatu Bot","Boot",this.getResources().getDrawable(R.drawable.boot));
        listWeather.add(weather);
        weather = new Weather("Mantel","Coat",this.getResources().getDrawable(R.drawable.coat));
        listWeather.add(weather);
        weather = new Weather("Berawan","Cloudy",this.getResources().getDrawable(R.drawable.cloudy));
        listWeather.add(weather);
        weather = new Weather("Cerah","Sunny",this.getResources().getDrawable(R.drawable.sunny));
        listWeather.add(weather);
        weather = new Weather("Hujan","Rain",this.getResources().getDrawable(R.drawable.drizzle));
        listWeather.add(weather);
        weather = new Weather("","",this.getResources().getDrawable(R.drawable.template_1));
        listWeather.add(weather);
        weather = new Weather("","",this.getResources().getDrawable(R.drawable.template_1));
        listWeather.add(weather);
        weather = new Weather("","",this.getResources().getDrawable(R.drawable.template_1));
        listWeather.add(weather);
        weather = new Weather("","",this.getResources().getDrawable(R.drawable.template_1));
        listWeather.add(weather);
        WeatherAdapter weatherAdapter = new WeatherAdapter(listWeather);
        rvWeather.setAdapter(weatherAdapter);

        rvWeather.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));

        return rootView;
    }

}
