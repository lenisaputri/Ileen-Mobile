package com.example.ileen_mobile.animal;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ileen_mobile.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MateriFragment extends Fragment {

    RecyclerView list_animal;

    private LinearLayoutManager linearLayoutManager;

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<AnimalMateri, MyViewHolder> mAdapter;

    public MateriFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDatabase = FirebaseDatabase.getInstance().getReference();

        View rootView = inflater.inflate(R.layout.fragment_materi, container, false);
        list_animal = rootView.findViewById(R.id.rvAnimal);

        list_animal.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<AnimalMateri>()
                .setQuery(query, AnimalMateri.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<AnimalMateri, MyViewHolder>(options) {
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View vh = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.item_materi_animal,parent,false);

                //4 membuat view holder

                final MyViewHolder viewHolder = new MyViewHolder(vh);

                return viewHolder;
            }
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final AnimalMateri model) {
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

        list_animal.setAdapter(mAdapter);
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
        Query query = mDatabase.child("animal");
        return query;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isiAnimal;
        public TextView isiJudul;

        public MyViewHolder( View itemView) {
            super(itemView);

            isiJudul = itemView.findViewById(R.id.judul_animal);
            isiAnimal = itemView.findViewById(R.id.isi_animal);
        }

        public void bindToConversation(AnimalMateri animalMateri, View.OnClickListener onClickListener){
            isiJudul.setText(animalMateri.judul);
            isiAnimal.setText(animalMateri.isi);
        }
    }
}
