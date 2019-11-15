package com.example.ileen_mobile.transportation;

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

public class TransportationAdapter extends RecyclerView.Adapter<TransportationAdapter.MyViewHolder>{
    //1 dataset
    private List<Transportation> listTrans = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public TransportationAdapter(List<Transportation> listTrans) {
        this.listTrans = listTrans;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_trans,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.trans_popup);


        viewHolder.transItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView transBing = myDialog.findViewById(R.id.bing);
                TextView transBind = myDialog.findViewById(R.id.bind);
                ImageView transImg = myDialog.findViewById(R.id.img);
                transBing.setText(listTrans.get(viewHolder.getAdapterPosition()).getBing());
                transBind.setText(listTrans.get(viewHolder.getAdapterPosition()).getBind());
                transImg.setImageDrawable(listTrans.get(viewHolder.getAdapterPosition()).getImage());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TransportationAdapter.MyViewHolder holder, int position) {
        Transportation item = listTrans.get(position);

        holder.imageTrans.setImageDrawable(item.getImage());
    }

    @Override
    public int getItemCount() {
        return listTrans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout transItem;
        public ImageView imageTrans;
        public TextView bingTitle;
        public TextView bindTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //6 menghubungkan id di layout ke view holder
            transItem = itemView.findViewById(R.id.trans_item);
            imageTrans = itemView.findViewById(R.id.image_trans);
            bindTitle = itemView.findViewById(R.id.bind);
            bingTitle = itemView.findViewById(R.id.bing);
        }
    }
}
