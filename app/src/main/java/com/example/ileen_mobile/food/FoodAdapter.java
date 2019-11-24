package com.example.ileen_mobile.food;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    //1 dataset
    private List<Food> listFood = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public FoodAdapter(List<Food> listFood) {
        this.listFood = listFood;
    }

    @NonNull
    @Override
    public FoodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_food,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.food_popup);

        viewHolder.foodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView foodBing = myDialog.findViewById(R.id.bing);
                TextView foodBind = myDialog.findViewById(R.id.bind);
                ImageView foodImg = myDialog.findViewById(R.id.img);
                foodBing.setText(listFood.get(viewHolder.getAdapterPosition()).getBing());
                foodBind.setText(listFood.get(viewHolder.getAdapterPosition()).getBind());
                foodImg.setImageDrawable(listFood.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();

//                switch(listFood.size())
//                {
//                    case 0  :
//                        MediaPlayer mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.bread);
//                        mediaPlayer.start();
//                        break;
//                    case 1:
//                        mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.cookies);
//                        mediaPlayer.start();
//                        break;
//                }
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.MyViewHolder holder, int position) {
        Food item = listFood.get(position);

        holder.imageFood.setImageDrawable(item.getImage());
//        holder.setItem(listFood.get(position));
    }

    @Override
    public int getItemCount() {
        return listFood.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout foodItem;
        public ImageView imageFood;
        public TextView bingTitle;
        public TextView bindTitle;
//        public Food mItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            foodItem = itemView.findViewById(R.id.food_item);
            imageFood = itemView.findViewById(R.id.image_food);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    MediaPlayer mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.bread);
//                    mediaPlayer.start();
//                }
//            });
        }

//        public void setItem(Food item)
//        {
//            mItem = item;
//        }

    }
}
