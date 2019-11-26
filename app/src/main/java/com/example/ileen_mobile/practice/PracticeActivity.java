package com.example.ileen_mobile.practice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;
import com.example.ileen_mobile.weather.WeatherActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.ileen_mobile.practice.Common;
import com.google.firebase.database.Query;

public class PracticeActivity extends AppCompatActivity{

    private RecyclerView listCategory;
    private GridLayoutManager gridLayoutManager;
    FirebaseRecyclerAdapter<Category, CategoryViewHolder> mAdapter;

    private DatabaseReference mDatabase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        mDatabase =  FirebaseDatabase.getInstance().getReference();

        listCategory = findViewById(R.id.listCategory);
        listCategory.setHasFixedSize(true);

        gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        listCategory.setLayoutManager(gridLayoutManager);

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(query, Category.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options)
        {
            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new CategoryViewHolder(inflater.inflate(R.layout.item_category, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder viewHolder, int position, @NonNull final Category model) {
                viewHolder.category_name.setText(model.getName());
                Glide.with(getApplicationContext())
                        .load(model.getImage())
                        .into(viewHolder.category_image);

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        //Toast.makeText(getActivity(), String.format("%s|%s", adapter.getRef(position).getKey(), model.getName()), Toast.LENGTH_SHORT).show();
                        Intent startGame = new Intent(getApplicationContext(),Start.class);
                        Common.categoryId = mAdapter.getRef(position).getKey();
                        startActivity(startGame);
                    }
                });
            }

        };
        mAdapter.notifyDataSetChanged();
        listCategory.setAdapter(mAdapter);

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

    private Query getQuery(DatabaseReference mDatabase) {
        Query query = mDatabase.child("Category");
        return query;
    }

}
