package com.example.notebook.helpers;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.notebook.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView catagoryTextView;
    public Button openBtn,deleteBtn;



    public NoteViewHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.item_title);
        catagoryTextView = itemView.findViewById(R.id.item_catagory);
        openBtn=itemView.findViewById(R.id.btn_open);
        deleteBtn=itemView.findViewById(R.id.btn_delete);
    }
}

