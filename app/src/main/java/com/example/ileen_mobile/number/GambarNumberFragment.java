package com.example.ileen_mobile.number;


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
public class GambarNumberFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvNumber;
    //instansiasi list superhero
    private NumberAdapter numberAdapter;
    List<Number> listNumber = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gambar_number, container, false);
        rvNumber = rootView.findViewById(R.id.rvNumber);

        Number num = new Number("Nol","Zero",this.getResources().getDrawable(R.drawable.zero));
        listNumber.add(num);
        num = new Number("Satu","One",this.getResources().getDrawable(R.drawable.one));
        listNumber.add(num);
        num = new Number("Dua","Two",this.getResources().getDrawable(R.drawable.two));
        listNumber.add(num);
        num = new Number("Tiga","Three",this.getResources().getDrawable(R.drawable.three));
        listNumber.add(num);
        num = new Number("Empat","Four",this.getResources().getDrawable(R.drawable.four));
        listNumber.add(num);
        num = new Number("Lima","Five",this.getResources().getDrawable(R.drawable.five));
        listNumber.add(num);
        num = new Number("Enam","Six",this.getResources().getDrawable(R.drawable.six));
        listNumber.add(num);
        num = new Number("Tujuh","Seven",this.getResources().getDrawable(R.drawable.seven));
        listNumber.add(num);
        num = new Number("Delapan","Eight",this.getResources().getDrawable(R.drawable.eight));
        listNumber.add(num);
        num = new Number("Sembilan","Nine",this.getResources().getDrawable(R.drawable.nine));
        listNumber.add(num);
        num = new Number("Sepuluh","Ten",this.getResources().getDrawable(R.drawable.ten));
        listNumber.add(num);
        num = new Number("Sebelas","Eleven",this.getResources().getDrawable(R.drawable.eleven));
        listNumber.add(num);
        num = new Number("Duabelas","Twelve",this.getResources().getDrawable(R.drawable.twelve));
        listNumber.add(num);
        num = new Number("Tigabelas","Thirteen",this.getResources().getDrawable(R.drawable.thirteen));
        listNumber.add(num);
        num = new Number("Setengah / Satu per dua","A half",this.getResources().getDrawable(R.drawable.half));
        listNumber.add(num);
        num = new Number("Seperempat / Satu per empat"," A quarter",this.getResources().getDrawable(R.drawable.quarter));
        listNumber.add(num);
        num = new Number("Dua per tiga","Two third",this.getResources().getDrawable(R.drawable.twothird));
        listNumber.add(num);
        num = new Number("Pertama","First",this.getResources().getDrawable(R.drawable.first));
        listNumber.add(num);
        num = new Number("Ke-dua","Second",this.getResources().getDrawable(R.drawable.second));
        listNumber.add(num);
        num = new Number("Ke-tiga","Third",this.getResources().getDrawable(R.drawable.third));
        listNumber.add(num);
        num = new Number("Ke-empat","Fourth",this.getResources().getDrawable(R.drawable.fourth));
        listNumber.add(num);
        num = new Number("","",this.getResources().getDrawable(R.drawable.template_1));
        listNumber.add(num);
        num = new Number("","",this.getResources().getDrawable(R.drawable.template_1));
        listNumber.add(num);
        num = new Number("","",this.getResources().getDrawable(R.drawable.template_1));
        listNumber.add(num);
        num = new Number("t","",this.getResources().getDrawable(R.drawable.template_1));
        listNumber.add(num);

        NumberAdapter numberAdapter = new NumberAdapter(listNumber);
        rvNumber.setAdapter(numberAdapter);

        rvNumber.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }

}
