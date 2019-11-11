package com.example.ileen_mobile.animal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;
import com.example.ileen_mobile.menu.MenuActivity;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder>{
    //1 dataset
    private List<Animal> listAnimal = new ArrayList<>();


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
        MyViewHolder viewHolder = new MyViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.MyViewHolder holder, int position) {
        Animal item = listAnimal.get(position);
//        holder.txtAnimal.setText(item.getJudul());
        holder.imageAnimal.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listAnimal.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageAnimal;
//        public TextView txtAnimal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //6 menghubungkan id di layout ke view holder
            imageAnimal = itemView.findViewById(R.id.image_animal);
//            txtAnimal = itemView.findViewById(R.id.txt_animal);
        }
    }
}
