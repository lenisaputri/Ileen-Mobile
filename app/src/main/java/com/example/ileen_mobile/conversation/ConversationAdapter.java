package com.example.ileen_mobile.conversation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;

import java.util.ArrayList;
import java.util.List;

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.MyViewHolder> {
    private List<Conversation> listConversation = new ArrayList<>();

    //2 constructor
    public ConversationAdapter(List<Conversation> listConversation) {

        this.listConversation = listConversation;
    }

    @NonNull
    @Override
    public ConversationAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_materi_conversation,viewGroup,false);
        //4 membuat view holder
        final MyViewHolder viewHolder = new MyViewHolder(vh);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationAdapter.MyViewHolder holder, int position) {
        Conversation item = listConversation.get(position);

        holder.isi.setText(item.getIsi_conversation());
    }

    @Override
    public int getItemCount() {

        return listConversation.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isi;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            isi = itemView.findViewById(R.id.isi_conversation);
        }
    }
}
