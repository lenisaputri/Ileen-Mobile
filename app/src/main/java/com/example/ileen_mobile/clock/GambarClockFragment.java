package com.example.ileen_mobile.clock;


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
public class GambarClockFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvClock;
    //instansiasi list superhero
    private ClockAdapter clockAdapter;
    List<Clock> listClock = new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    public GambarClockFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gambar_clock, container, false);
        rvClock = rootView.findViewById(R.id.rvClock);

        Clock clock = new Clock("Jam Beker","Alarm Clock",this.getResources().getDrawable(R.drawable.alarmclock));
        listClock.add(clock);
        clock = new Clock("Jam Dinding","Clock",this.getResources().getDrawable(R.drawable.clock));
        listClock.add(clock);
        clock = new Clock("Jam Tangan","Watch",this.getResources().getDrawable(R.drawable.watch));
        listClock.add(clock);
        clock = new Clock("Jam satu tepat","One o'clock",this.getResources().getDrawable(R.drawable.oneoclock));
        listClock.add(clock);
        clock = new Clock("Jam enam tepat","Six o'clock",this.getResources().getDrawable(R.drawable.sixoclock));
        listClock.add(clock);
        clock = new Clock("Jam tiga tepat","Three o'clock",this.getResources().getDrawable(R.drawable.threeoclock));
        listClock.add(clock);
        clock = new Clock("Jam duabelas tepat","Twelve o'clock",this.getResources().getDrawable(R.drawable.twelveoclock));
        listClock.add(clock);
        clock = new Clock("Jam satu lebih 30 menit","One thirty",this.getResources().getDrawable(R.drawable.onethirty));
        listClock.add(clock);
        clock = new Clock("Jam sepuluh lebih 30 menit","Ten thirty",this.getResources().getDrawable(R.drawable.tenthirty));
        listClock.add(clock);
        clock = new Clock("Jam lima lebih empatpuluhlima menit","Five forty-five",this.getResources().getDrawable(R.drawable.fivefortyfive));
        listClock.add(clock);
        clock = new Clock("Jam enam lebih 10 menit","Six past ten",this.getResources().getDrawable(R.drawable.sixpastten));
        listClock.add(clock);
        clock = new Clock("Jam sembilan lebih limabelas menit","Nine past fifteen",this.getResources().getDrawable(R.drawable.ninepastfifteen));
        listClock.add(clock);

        ClockAdapter clockAdapter = new ClockAdapter(listClock);
        rvClock.setAdapter(clockAdapter);

        rvClock.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        return rootView;
    }

}
