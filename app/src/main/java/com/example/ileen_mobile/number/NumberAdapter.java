package com.example.ileen_mobile.number;

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

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.MyViewHolder> {
    //1 dataset
    private List<Number> listNumber = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public NumberAdapter(List<Number> listNumber) {
        this.listNumber = listNumber;
    }

    @NonNull
    @Override
    public NumberAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_number,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.number_popup);


        viewHolder.numberItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView numberBing = myDialog.findViewById(R.id.bing);
                TextView numberBind = myDialog.findViewById(R.id.bind);
                ImageView numberImg = myDialog.findViewById(R.id.img);
                numberBing.setText(listNumber.get(viewHolder.getAdapterPosition()).getBing());
                numberBind.setText(listNumber.get(viewHolder.getAdapterPosition()).getBind());
                numberImg.setImageDrawable(listNumber.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberAdapter.MyViewHolder holder, int position) {
        Number item = listNumber.get(position);

        holder.imageNumber.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listNumber.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout numberItem;
        public ImageView imageNumber;
        public TextView bingTitle;
        public TextView bindTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            numberItem = itemView.findViewById(R.id.number_item);
            imageNumber = itemView.findViewById(R.id.image_number);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);
        }
    }
}
