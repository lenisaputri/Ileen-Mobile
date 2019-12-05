package com.example.ileen_mobile.sport;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MateriSportFragment extends Fragment {
    RecyclerView list_sport;

    private LinearLayoutManager linearLayoutManager;

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<SportMateri, MyViewHolder> mAdapter;

    public MateriSportFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDatabase = FirebaseDatabase.getInstance().getReference();

        View rootView = inflater.inflate(R.layout.fragment_materi_sport, container, false);
        list_sport = rootView.findViewById(R.id.rvSport);

        list_sport.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<SportMateri>()
                .setQuery(query, SportMateri.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<SportMateri, MyViewHolder>(options) {
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View vh = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.item_materi_sport,parent,false);

                final MyViewHolder viewHolder = new MyViewHolder(vh);

                return viewHolder;
            }
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final SportMateri model) {
                holder.bindToConversation(model, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        startActivity(intent);
                    }
                });
            }
        };

        mAdapter.notifyDataSetChanged();

        list_sport.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase){
        Query query = mDatabase.child("sport");
        return query;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isiSport;
        public TextView isiJudul;

        public MyViewHolder( View itemView) {
            super(itemView);

            isiJudul = itemView.findViewById(R.id.judul_sport);
            isiSport= itemView.findViewById(R.id.isi_sport);
        }

        public void bindToConversation(SportMateri sportMateri, View.OnClickListener onClickListener){
            isiJudul.setText(sportMateri.judul);
            isiSport.setText(sportMateri.isi);
        }
    }

}
