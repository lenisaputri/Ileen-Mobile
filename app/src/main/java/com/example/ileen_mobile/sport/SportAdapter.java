package com.example.ileen_mobile.sport;

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

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.MyViewHolder> {
    //1 dataset
    private List<Sport> listSport = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public SportAdapter(List<Sport> listSport) {
        this.listSport = listSport;
    }

    @NonNull
    @Override
    public SportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_sport,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.sport_popup);


        viewHolder.sportItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView sportBing = myDialog.findViewById(R.id.bing);
                TextView sportBind = myDialog.findViewById(R.id.bind);
                ImageView sportImg = myDialog.findViewById(R.id.img);
                sportBing.setText(listSport.get(viewHolder.getAdapterPosition()).getBing());
                sportBind.setText(listSport.get(viewHolder.getAdapterPosition()).getBind());
                sportImg.setImageDrawable(listSport.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.MyViewHolder holder, int position) {
        Sport item = listSport.get(position);

        holder.imageSport.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listSport.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout sportItem;
        public ImageView imageSport;
        public TextView bingTitle;
        public TextView bindTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //6 menghubungkan id di layout ke view holder
            sportItem = itemView.findViewById(R.id.sport_item);
            imageSport = itemView.findViewById(R.id.image_sport);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);
        }
    }
}
