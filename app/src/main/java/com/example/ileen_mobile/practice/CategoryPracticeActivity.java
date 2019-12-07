package com.example.ileen_mobile.practice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ileen_mobile.R;
import com.example.ileen_mobile.practice.Common.Common;
import com.example.ileen_mobile.practice.Interface.ItemClickListener;
import com.example.ileen_mobile.practice.Model.Category;
import com.example.ileen_mobile.practice.ViewHolder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CategoryPracticeActivity extends AppCompatActivity {
    RecyclerView listCategory;
    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;
    FirebaseDatabase database;
    DatabaseReference categories;

    String completed = "1"; // level yang terakhir dikerjakan, tapi belum tentu lulus
    final int[] allScore = new int[12]; // semua score dari setiap level yang dikerjakan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_practice);

        database = FirebaseDatabase.getInstance();
        categories = database.getReference("Category");

        listCategory = findViewById(R.id.listCategory);
        listCategory.setHasFixedSize(true);
        listCategory.setLayoutManager(new GridLayoutManager(this, 3));

        initAllLevel();
    }

    // karena ketika di back dari Start, activity ini ter-restart
    // maka harus panggil lifecycle onRestart untuk render ulang kategorinya
    @Override
    protected void onRestart() {
        super.onRestart();
        initAllLevel();
    }

    private void getData() {
        final String userLogin = Common.currentUser.getUserName();
        final Query level = database.getReference("Question_Score").orderByChild("user").equalTo(userLogin); // ambil data di field Question_Score dengan nilai di key user = user yang login
        final Query lastLevel = level.limitToLast(1); // ambil item terakhir dari semua level yang pernah dikerjakan

        level.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int i = 0;
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    // ambil score di setiap level yang pernah dikerjakan
                    String score = data.child("score").getValue(String.class);

                    if (score != null)
                        allScore[i] = Integer.valueOf(score);

                    i++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("onCancelled", databaseError.toException());
            }
        });

        lastLevel.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    // ambil level yang terakhir dikerjakan
                    String categoryId = data.child("categoryId").getValue(String.class);

                    if (categoryId != null) {
                        completed = categoryId;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("onCancelled", databaseError.toException());
            }
        });
    }

    private void initAllLevel() {
        getData();
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
                return new CategoryViewHolder(inflater.inflate(R.layout.category_layout, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder viewHolder, final int pos, @NonNull final Category model) {
                viewHolder.category_name.setText(model.getName());
                Glide.with(viewHolder.itemView)
                        .load(model.getImage())
                        .into(viewHolder.category_image);

                renderLevel(pos, viewHolder);

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        if (position > 0) {
                            // jika score di level sebelum level ini adalah 0, berarti level tersebut belum dikerjakan
                            if (allScore[position - 1] == 0) {
                                Toast.makeText(view.getContext(), "Kamu belum menyelesaikan level " + position, Toast.LENGTH_SHORT).show();
                            } else {
                                // jika score di level sebelum level ini < 70, maka tidak lulus atau belum bisa lanjut ke level ini
                                if (allScore[position - 1] < 70) {
                                    Toast.makeText(view.getContext(), "Nilaimu di level " + position + " kurang dari 70 nih", Toast.LENGTH_SHORT).show();
                                } else {
                                    playLevel(view, position, model);
                                }
                            }
                        } else {
                            playLevel(view, position, model);
                        }
                    }
                });
            }

        };
        adapter.notifyDataSetChanged();
        listCategory.setAdapter(adapter);
    }

    // render per level
    private void renderLevel(int position, CategoryViewHolder viewHolder) {
        // jika level ini >= level yang terakhir dikerjakan dan nilai di level ini < 70
        // maka level ini tampilannya di transparan 50%
        if (position >= Integer.valueOf(completed) && allScore[position - 1] < 70) {
            viewHolder.category_image.setAlpha(0.5f);
        }
    }

    private void playLevel(View view, int position, Category model) {
        Intent startGame = new Intent(view.getContext(), Start.class);
        Common.categoryId = adapter.getRef(position).getKey();
        Common.categoryName = model.getName();
        startActivity(startGame);
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
