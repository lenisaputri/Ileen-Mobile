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

public class PracticeActivity extends AppCompatActivity{

    RecyclerView listCategory;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference categories;

    public static PracticeActivity newInstances()
    {
        PracticeActivity practiceActivity = new PracticeActivity();
        return practiceActivity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        database = FirebaseDatabase.getInstance();
        categories = database.getReference("Category");

        listCategory = findViewById(R.id.listCategory);
        listCategory.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getApplicationContext(),2);
        listCategory.setLayoutManager(layoutManager);
        listCategory.setAdapter(adapter);

        loadCategories();
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        myFragment = inflater.inflate(R.layout.activity_practice,container,false);
//
//        listCategory = myFragment.findViewById(R.id.listCategory);
//        listCategory.setHasFixedSize(true);
//        layoutManager = new GridLayoutManager(container.getContext(),2);
//        listCategory.setLayoutManager(layoutManager);
//
//        loadCategories();
//
//        return myFragment;
//    }

    private void loadCategories() {
        FirebaseRecyclerOptions<Category> options =
                new FirebaseRecyclerOptions.Builder<Category>()
                        .setQuery(categories, Category.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options)
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
                        Common.categoryId = adapter.getRef(position).getKey();
                        startActivity(startGame);
                    }
                });
            }

        };
        adapter.notifyDataSetChanged();
        listCategory.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}
