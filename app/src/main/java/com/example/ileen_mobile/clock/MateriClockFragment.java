package com.example.ileen_mobile.clock;


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

public class MateriClockFragment extends Fragment {
    RecyclerView list_clock;

    private LinearLayoutManager linearLayoutManager;

    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<ClockMateri, MyViewHolder> mAdapter;

    public MateriClockFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDatabase = FirebaseDatabase.getInstance().getReference();

        View rootView = inflater.inflate(R.layout.fragment_materi_clock, container, false);
        list_clock = rootView.findViewById(R.id.rvClock);

        list_clock.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<ClockMateri>()
                    .setQuery(query, ClockMateri.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<ClockMateri, MyViewHolder>(options) {
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View vh = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.item_materi_clock,parent,false);

                final MyViewHolder viewHolder = new MyViewHolder(vh);

                return viewHolder;
            }
            @Override
            protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull final ClockMateri model) {
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

        list_clock.setAdapter(mAdapter);
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
        Query query = mDatabase.child("clock");
        return query;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isiClock;
        public TextView isiJudul;

        public MyViewHolder( View itemView) {
            super(itemView);

            isiJudul = itemView.findViewById(R.id.judul_clock);
            isiClock = itemView.findViewById(R.id.isi_clock);
        }

        public void bindToConversation(ClockMateri clockMateri, View.OnClickListener onClickListener){
            isiJudul.setText(clockMateri.judul);
            isiClock.setText(clockMateri.isi);
        }
    }

}
