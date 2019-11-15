package com.example.ileen_mobile.transportation;


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
public class GambarTransportationFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvTrans;
    //instansiasi list superhero
    private TransportationAdapter transportationAdapter;
    List<Transportation> listTrans = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarTransportationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_gambar_transportation, container, false);
        rvTrans = rootView.findViewById(R.id.rvTrans);

        Transportation transportation = new Transportation("Balon Udara","Air Balloon",this.getResources().getDrawable(R.drawable.airballoon));
        listTrans.add(transportation);
        transportation = new Transportation("Pesawat Terbang","Airplane",this.getResources().getDrawable(R.drawable.airplane));
        listTrans.add(transportation);
        transportation = new Transportation("Sepeda","Bike",this.getResources().getDrawable(R.drawable.bike));
        listTrans.add(transportation);
        transportation = new Transportation("Perahu","Boat",this.getResources().getDrawable(R.drawable.boat));
        listTrans.add(transportation);
        transportation = new Transportation("Bus","Bus",this.getResources().getDrawable(R.drawable.bus));
        listTrans.add(transportation);
        transportation = new Transportation("Mobil","Car",this.getResources().getDrawable(R.drawable.car));
        listTrans.add(transportation);
        transportation = new Transportation("Kapal Pesiar","Cruise Ship",this.getResources().getDrawable(R.drawable.cruiseship));
        listTrans.add(transportation);
        transportation = new Transportation("Helikopter","Helicopter",this.getResources().getDrawable(R.drawable.helicopter));
        listTrans.add(transportation);
        transportation = new Transportation("Sepeda Motor","Motorcycle",this.getResources().getDrawable(R.drawable.motorcycle));
        listTrans.add(transportation);
        transportation = new Transportation("Pesawat","Plane",this.getResources().getDrawable(R.drawable.plane));
        listTrans.add(transportation);
        transportation = new Transportation("Sekuter","Scooter",this.getResources().getDrawable(R.drawable.scooter));
        listTrans.add(transportation);
        transportation = new Transportation("Taksi","Taxi",this.getResources().getDrawable(R.drawable.taxi));
        listTrans.add(transportation);
        transportation = new Transportation("Kereta Api","Train",this.getResources().getDrawable(R.drawable.train));
        listTrans.add(transportation);
        transportation = new Transportation("Truk","Truck",this.getResources().getDrawable(R.drawable.truck));
        listTrans.add(transportation);
        transportation = new Transportation("Kapal","Yatch",this.getResources().getDrawable(R.drawable.yatch));
        listTrans.add(transportation);
        transportation = new Transportation("","",this.getResources().getDrawable(R.drawable.template_1));
        listTrans.add(transportation);
        transportation = new Transportation("","",this.getResources().getDrawable(R.drawable.template_1));
        listTrans.add(transportation);
        transportation = new Transportation("","",this.getResources().getDrawable(R.drawable.template_1));
        listTrans.add(transportation);
        transportation = new Transportation("","",this.getResources().getDrawable(R.drawable.template_1));
        listTrans.add(transportation);

        TransportationAdapter transportationAdapter = new TransportationAdapter(listTrans);
        rvTrans.setAdapter(transportationAdapter);

        rvTrans.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }

}
