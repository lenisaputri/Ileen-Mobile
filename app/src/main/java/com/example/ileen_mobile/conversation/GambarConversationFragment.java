package com.example.ileen_mobile.conversation;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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
public class GambarConversationFragment extends Fragment {
    //instansiasi Recyclerview
    RecyclerView rvConversation;
    //instansiasi list superhero
    private ConversationAdapter conAdapter;
    List<Conversation> listCon = new ArrayList<>();

    public GambarConversationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gambar_conversation, container, false);

        rvConversation = rootView.findViewById(R.id.rvConversation);

        Conversation con = new Conversation("ANIMAL",this.getResources().getDrawable(R.drawable.animal));
        listCon.add(con);
        con = new Conversation("APOLOGY",this.getResources().getDrawable(R.drawable.apology));
        listCon.add(con);
        con = new Conversation("BORROW",this.getResources().getDrawable(R.drawable.borrow));
        listCon.add(con);
        con = new Conversation("CONDOLENCES",this.getResources().getDrawable(R.drawable.condolences));
        listCon.add(con);
        con = new Conversation("CONGRATULATED",this.getResources().getDrawable(R.drawable.congratulated));
        listCon.add(con);
        con = new Conversation("DRINK",this.getResources().getDrawable(R.drawable.drink));
        listCon.add(con);
        con = new Conversation("FOOD",this.getResources().getDrawable(R.drawable.food));
        listCon.add(con);
        con = new Conversation("GREETING",this.getResources().getDrawable(R.drawable.greeting));
        listCon.add(con);
        con = new Conversation("HOBBY",this.getResources().getDrawable(R.drawable.hobby));
        listCon.add(con);
        con = new Conversation("INTRODUCTION",this.getResources().getDrawable(R.drawable.introduction));
        listCon.add(con);
        con = new Conversation("PRAISE",this.getResources().getDrawable(R.drawable.praise));
        listCon.add(con);
        con = new Conversation("PRICE",this.getResources().getDrawable(R.drawable.price));
        listCon.add(con);
        con = new Conversation("SPORT",this.getResources().getDrawable(R.drawable.sport));
        listCon.add(con);
        con = new Conversation("TIME",this.getResources().getDrawable(R.drawable.time));
        listCon.add(con);
        con = new Conversation("WEATHER",this.getResources().getDrawable(R.drawable.weather));
        listCon.add(con);
        con = new Conversation("",this.getResources().getDrawable(R.drawable.template_1));
        listCon.add(con);
        con = new Conversation("",this.getResources().getDrawable(R.drawable.template_1));
        listCon.add(con);

        ConversationAdapter conAdapter = new ConversationAdapter(listCon);
        rvConversation.setAdapter(conAdapter);

        rvConversation.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return rootView;
    }

}
