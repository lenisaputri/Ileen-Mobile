package com.example.ileen_mobile.conversation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;


public class MateriConversationFragment extends Fragment {

    //instansiasi Recyclerview
    RecyclerView list_conversation;
    //instansiasi list superhero
    private ConversationAdapter conversationAdapter;
    List<Conversation> listConversation = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;

    public MateriConversationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_materi_conversation, container, false);
        list_conversation = rootView.findViewById(R.id.rvConversation);

        Conversation conversation = new Conversation("dksmsksknfdsknfs");
        listConversation.add(conversation);

        conversation = new Conversation("dksmsksknfdsknfs");
        listConversation.add(conversation);

        conversation = new Conversation("dksmsksknfdsknfs");
        listConversation.add(conversation);

        ConversationAdapter conversationAdapter = new ConversationAdapter(listConversation);
        list_conversation.setAdapter(conversationAdapter);

        list_conversation.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return rootView;
    }
}
