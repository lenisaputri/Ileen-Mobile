package com.example.ileen_mobile.menu.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ileen_mobile.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment1 extends Fragment {


    public MenuFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_fragment1, container, false);
    }

}
