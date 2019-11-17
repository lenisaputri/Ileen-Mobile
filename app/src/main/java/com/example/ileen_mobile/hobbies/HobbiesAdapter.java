package com.example.ileen_mobile.hobbies;

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

public class HobbiesAdapter extends RecyclerView.Adapter<HobbiesAdapter.MyViewHolder> {
    //1 dataset
    private List<Hobbies> listHobbies = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public HobbiesAdapter(List<Hobbies> listHobbies) {
        this.listHobbies = listHobbies;
    }


    @NonNull
    @Override
    public HobbiesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_hobbies,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.hobbies_popup);


        viewHolder.hobbiesItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView hobbiesBing = myDialog.findViewById(R.id.bing);
                TextView hobbiesBind = myDialog.findViewById(R.id.bind);
                ImageView hobbiesImg = myDialog.findViewById(R.id.img);
                hobbiesBing.setText(listHobbies.get(viewHolder.getAdapterPosition()).getBing());
                hobbiesBind.setText(listHobbies.get(viewHolder.getAdapterPosition()).getBind());
                hobbiesImg.setImageDrawable(listHobbies.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HobbiesAdapter.MyViewHolder holder, int position) {
        Hobbies item = listHobbies.get(position);

        holder.imageHobbies.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listHobbies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout hobbiesItem;
        public ImageView imageHobbies;
        public TextView bingTitle;
        public TextView bindTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hobbiesItem = itemView.findViewById(R.id.hobbies_item);
            imageHobbies = itemView.findViewById(R.id.image_hobbies);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);
        }
    }
}
