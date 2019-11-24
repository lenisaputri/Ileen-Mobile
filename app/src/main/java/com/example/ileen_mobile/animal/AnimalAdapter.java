package com.example.ileen_mobile.animal;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder>{
    //1 dataset
    private List<Animal> listAnimal = new ArrayList<>();
    Dialog myDialog;

    //2 constructor
    public AnimalAdapter(List<Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }

    @NonNull
    @Override
    public AnimalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_animal,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.animal_popup);


        viewHolder.animalItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView animalBing = myDialog.findViewById(R.id.bing);
                TextView animalBind = myDialog.findViewById(R.id.bind);
                ImageView animalImg = myDialog.findViewById(R.id.img);
                animalBing.setText(listAnimal.get(viewHolder.getAdapterPosition()).getBing());
                animalBind.setText(listAnimal.get(viewHolder.getAdapterPosition()).getBind());
//                animalImg.setImageDrawable(listAnimal.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.MyViewHolder holder, int position) {
        Animal item = listAnimal.get(position);

//        holder.imageAnimal.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listAnimal.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout animalItem;
        public ImageView imageAnimal;
        public TextView bingTitle;
        public TextView bindTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //6 menghubungkan id di layout ke view holder
            animalItem = itemView.findViewById(R.id.animal_item);
            imageAnimal = itemView.findViewById(R.id.image_animal);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);
        }
    }
}
