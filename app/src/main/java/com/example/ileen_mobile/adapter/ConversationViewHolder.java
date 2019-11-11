package com.example.ileen_mobile.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ileen_mobile.R;
import com.example.ileen_mobile.models.Conversation;

public class ConversationViewHolder extends RecyclerView.ViewHolder{
    public TextView isiConversation;

    public ConversationViewHolder(View itemView) {
        super(itemView);
        isiConversation = itemView.findViewById(R.id.isi_conversation);
    }

    public void bindToConversation(Conversation conversation, View.OnClickListener onClickListener){
        isiConversation.setText(conversation.isi_conversation);
    }
}