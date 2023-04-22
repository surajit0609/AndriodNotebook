package com.example.notebook.helpers;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.notebook.AddNoteActivity;
import com.example.notebook.MainActivity;
import com.example.notebook.R;
import com.example.notebook.models.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private List<Note> dataList;

    public NoteAdapter(List<Note> dataList) {
        this.dataList = dataList;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_design, parent, false);

        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note data = dataList.get(position);

        holder.titleTextView.setText(data.getTitle());
        holder.catagoryTextView.setText(data.getCatagory());
        holder.openBtn.setTag(data.getId());
        holder.openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(holder.openBtn.getContext(), AddNoteActivity.class);
                i.putExtra("id",data.getId());
                holder.openBtn.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

