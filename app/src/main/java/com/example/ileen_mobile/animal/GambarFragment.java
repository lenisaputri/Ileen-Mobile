package com.example.ileen_mobile.animal;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ileen_mobile.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;


public class GambarFragment extends Fragment {

    Dialog myDialog;

    private DatabaseReference mDatabase;

    private FirebaseRecyclerAdapter<Animal, MyViewHolder> mAdapter;

    private GridLayoutManager gridLayoutManager;
    private RecyclerView rvAnimal;

    public GambarFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        View rootView = inflater.inflate(R.layout.fragment_gambar, container, false);
        rvAnimal = rootView.findViewById(R.id.rvAnimal);
        rvAnimal.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Animal>()
                .setQuery(query, Animal.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Animal, MyViewHolder>(options) {
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View vh = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.item_animal,parent,false);

                //4 membuat view holder

                final MyViewHolder viewHolder = new MyViewHolder(vh);

                myDialog = new Dialog(parent.getContext());
                myDialog.setContentView(R.layout.animal_popup);

                return viewHolder;
            }
            @Override
            protected void onBindViewHolder(@NonNull final MyViewHolder holder, int position, @NonNull final Animal model) {

                holder.setDisplayImage(model.getImage_url(), GambarFragment.this);

                holder.animalItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView animalBing = myDialog.findViewById(R.id.bing_name);
                        TextView animalBind = myDialog.findViewById(R.id.bind_name);
                        ImageView animalImg = myDialog.findViewById(R.id.img);



                        myDialog.show();
                    }
                });

            }
        };

        mAdapter.notifyDataSetChanged();

        rvAnimal.setAdapter(mAdapter);

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
        Query query = mDatabase.child("animal-example");
        return query;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AdapterView.OnItemClickListener listener;

        public ConstraintLayout animalItem;
        public ImageView imageAnimal;
        public TextView bingTitle;
        public TextView bindTitle;

        public MyViewHolder( View itemView) {
            super(itemView);

            animalItem = itemView.findViewById(R.id.animal_item);
            imageAnimal = itemView.findViewById(R.id.image_animal);
            bindTitle = itemView.findViewById(R.id.bind_name);
            bingTitle = itemView.findViewById(R.id.bing_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        public void bindToAnimal(Animal animal, View.OnClickListener onClickListener){
            bindTitle.setText(animal.bind);
            bingTitle.setText(animal.bing);
        }

        public void setDisplayImage(String imageUrl, GambarFragment context) {
            Glide.with(context)
                    .load(imageUrl)
                    .into(imageAnimal);
        }

    }

}