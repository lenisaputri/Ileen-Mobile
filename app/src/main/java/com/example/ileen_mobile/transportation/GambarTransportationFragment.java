package com.example.ileen_mobile.transportation;


import android.app.Dialog;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ileen_mobile.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.IOException;

public class GambarTransportationFragment extends Fragment {
    Dialog myDialog;

    private MediaPlayer mediaPlayer;

    private DatabaseReference mDatabase;

    private Handler threadHandler = new Handler();

    private FirebaseRecyclerAdapter<Transportation, MyViewHolder> mAdapter;

    private GridLayoutManager gridLayoutManager;
    private RecyclerView rvTrans;

    public GambarTransportationFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mDatabase = FirebaseDatabase.getInstance().getReference();

        View rootView = inflater.inflate(R.layout.fragment_gambar_transportation, container, false);
        rvTrans = rootView.findViewById(R.id.rvTrans);
        rvTrans.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));

        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Transportation>()
                .setQuery(query, Transportation.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Transportation, MyViewHolder>(options) {
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View vh = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.item_trans,parent,false);

                //4 membuat view holder

                final MyViewHolder viewHolder = new MyViewHolder(vh);

                myDialog = new Dialog(parent.getContext());
                myDialog.setContentView(R.layout.trans_popup);

                return viewHolder;
            }
            @Override
            protected void onBindViewHolder(@NonNull final MyViewHolder holder, int position, @NonNull final Transportation model) {

                holder.setDisplayImage(model.getImage_url(), GambarTransportationFragment.this);

                holder.transItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        TextView transBing = myDialog.findViewById(R.id.bing_name);
                        TextView transBind = myDialog.findViewById(R.id.bind_name);
                        ImageView transImg = myDialog.findViewById(R.id.img);

                        final Button buttonStart = myDialog.findViewById(R.id.button_start);
                        final Button buttonExit = myDialog.findViewById(R.id.button_exit);

                        transBing.setText(model.getBing());
                        transBind.setText(model.getBind());

                        Glide.with(getActivity())
                                .load(model.getImage_url())
                                .into(transImg);

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

                        buttonExit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mediaPlayer.stop();
                                myDialog.cancel();
                            }

                        });

                        myDialog.show();
                    }
                });

            }
        };

        mAdapter.notifyDataSetChanged();

        rvTrans.setAdapter(mAdapter);

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
        Query query = mDatabase.child("transportation-example");
        return query;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AdapterView.OnItemClickListener listener;

        public ConstraintLayout transItem;
        public ImageView imageTrans;
        public TextView bingTitle;
        public TextView bindTitle;

        public MyViewHolder( View itemView) {
            super(itemView);

            transItem = itemView.findViewById(R.id.trans_item);
            imageTrans = itemView.findViewById(R.id.image_trans);
            bindTitle = itemView.findViewById(R.id.bind_name);
            bingTitle = itemView.findViewById(R.id.bing_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        public void setDisplayImage(String imageUrl, GambarTransportationFragment context) {
            Glide.with(context)
                    .load(imageUrl)
                    .into(imageTrans);
        }

    }
}
