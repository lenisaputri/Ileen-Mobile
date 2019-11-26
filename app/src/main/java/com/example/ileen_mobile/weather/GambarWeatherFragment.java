package com.example.ileen_mobile.weather;


import android.app.Dialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ileen_mobile.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GambarWeatherFragment extends Fragment {
    Dialog myDialog;

    private MediaPlayer mediaPlayer;

    private DatabaseReference mDatabase;

    private Handler threadHandler = new Handler();

    private FirebaseRecyclerAdapter<Weather, MyViewHolder> mAdapter;

    private GridLayoutManager gridLayoutManager;
    private RecyclerView rvWeather;

    public GambarWeatherFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        View rootView = inflater.inflate(R.layout.fragment_gambar_weather, container, false);
        rvWeather = rootView.findViewById(R.id.rvWeather);
        rvWeather.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Weather>()
                .setQuery(query, Weather.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Weather, MyViewHolder>(options) {
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View vh = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.item_weather,parent,false);

                //4 membuat view holder

                final MyViewHolder viewHolder = new MyViewHolder(vh);

                myDialog = new Dialog(parent.getContext());
                myDialog.setContentView(R.layout.weather_popup);

                return viewHolder;
            }
            @Override
            protected void onBindViewHolder(@NonNull final MyViewHolder holder, int position, @NonNull final Weather model) {

                holder.setDisplayImage(model.getImage_url(), GambarWeatherFragment.this);

                holder.weatherItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        TextView weatherBing = myDialog.findViewById(R.id.bing_name);
                        TextView weatherBind = myDialog.findViewById(R.id.bind_name);
                        ImageView weatherImg = myDialog.findViewById(R.id.img);

                        final Button buttonStart = myDialog.findViewById(R.id.button_start);

                        weatherBing.setText(model.getBing());
                        weatherBind.setText(model.getBind());

                        Glide.with(getActivity())
                                .load(model.getImage_url())
                                .into(weatherImg);

                        buttonStart.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mediaPlayer = new MediaPlayer();
                                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                                try {
                                    mediaPlayer.setDataSource(model.getAudio_url());
                                    mediaPlayer.prepare();
                                    mediaPlayer.start();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }

                        });

                        myDialog.show();
                    }
                });

            }
        };

        mAdapter.notifyDataSetChanged();

        rvWeather.setAdapter(mAdapter);

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
        Query query = mDatabase.child("weather-example");
        return query;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AdapterView.OnItemClickListener listener;

        public ConstraintLayout weatherItem;
        public ImageView imageWeather;
        public TextView bingTitle;
        public TextView bindTitle;

        public MyViewHolder( View itemView) {
            super(itemView);

            weatherItem = itemView.findViewById(R.id.weather_item);
            imageWeather = itemView.findViewById(R.id.image_weather);
            bindTitle = itemView.findViewById(R.id.bind_name);
            bingTitle = itemView.findViewById(R.id.bing_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        public void setDisplayImage(String imageUrl, GambarWeatherFragment context) {
            Glide.with(context)
                    .load(imageUrl)
                    .into(imageWeather);
        }

    }
}
