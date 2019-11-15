package com.example.ileen_mobile.clock;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;

public class ClockAdapter extends RecyclerView.Adapter<ClockAdapter.MyViewHolder> {
    //1 dataset
    private List<Clock> listClock = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public ClockAdapter(List<Clock> listClock) {
        this.listClock = listClock;
    }

    @NonNull
    @Override
    public ClockAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_clock,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.clock_popup);


        viewHolder.clockItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView clockBing = myDialog.findViewById(R.id.bing);
                TextView clockBind = myDialog.findViewById(R.id.bind);
                ImageView clockImg = myDialog.findViewById(R.id.img);
                clockBing.setText(listClock.get(viewHolder.getAdapterPosition()).getBing());
                clockBind.setText(listClock.get(viewHolder.getAdapterPosition()).getBind());
                clockImg.setImageDrawable(listClock.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClockAdapter.MyViewHolder holder, int position) {
        Clock item = listClock.get(position);

        holder.imageClock.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listClock.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout clockItem;
        public ImageView imageClock;
        public TextView bingTitle;
        public TextView bindTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            clockItem = itemView.findViewById(R.id.clock_item);
            imageClock = itemView.findViewById(R.id.image_clock);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);
        }
    }
}
