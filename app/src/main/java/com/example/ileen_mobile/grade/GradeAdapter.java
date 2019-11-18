package com.example.ileen_mobile.grade;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.MyViewHolder> {
    //1 dataset
    private List<Grade> listGrade = new ArrayList<>();


    //2 constructor
    public GradeAdapter(List<Grade> listGrade) {
        this.listGrade = listGrade;
    }

    @NonNull
    @Override
    public GradeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_grade,viewGroup,false);

        //4 membuat view holder
        MyViewHolder viewHolder = new MyViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GradeAdapter.MyViewHolder holder, int position) {
        Grade item = listGrade.get(position);
        holder.txtNilai.setText(item.getNilai());
        holder.txtSoal.setText(item.getSoal());
        holder.txtLevel.setText(item.getLev());
        holder.imageLevel.setImageDrawable(item.getLevel());
    }

    @Override
    public int getItemCount() {
        return listGrade.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageLevel;
        public TextView txtLevel;
        public TextView txtNilai;
        public TextView txtSoal;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageLevel = itemView.findViewById(R.id.image_level);
            txtLevel = itemView.findViewById(R.id.level);
            txtNilai = itemView.findViewById(R.id.srore);
            txtSoal = itemView.findViewById(R.id.question);
        }
    }
}
