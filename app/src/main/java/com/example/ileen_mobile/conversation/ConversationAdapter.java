package com.example.ileen_mobile.conversation;

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

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.MyViewHolder> {
    //1 dataset
    private List<Conversation> listCon = new ArrayList<>();
    Dialog myDialog;


    //2 constructor
    public ConversationAdapter(List<Conversation> listCon) {
        this.listCon = listCon;
    }

    @NonNull
    @Override
    public ConversationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_conversation,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        myDialog = new Dialog(viewGroup.getContext());
        myDialog.setContentView(R.layout.conversation_popup);


        viewHolder.conItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView conImg = myDialog.findViewById(R.id.img);
                conImg.setImageDrawable(listCon.get(viewHolder.getAdapterPosition()).getDialog());

                myDialog.show();
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationAdapter.MyViewHolder holder, int position) {
        Conversation item = listCon.get(position);

        holder.txtTopik.setText(item.getTopik());
    }

    @Override
    public int getItemCount() {
        return listCon.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout conItem;
        public TextView txtTopik;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            conItem = itemView.findViewById(R.id.conversation_item);
            txtTopik = itemView.findViewById(R.id.topik);
        }
    }
}
