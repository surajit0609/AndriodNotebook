package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.notebook.helpers.LocaldbHelper;
import com.example.notebook.helpers.NoteAdapter;
import com.example.notebook.models.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button cre_btn;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cre_btn=findViewById(R.id.btn_create);
        recyclerView=findViewById(R.id.rec);
        LocaldbHelper localdbHelper=new LocaldbHelper(MainActivity.this);
        ArrayList<Note> noteList =new ArrayList<>();
        noteList= localdbHelper.getNotes();
        NoteAdapter noteAdapter=new NoteAdapter(noteList);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cre_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,AddNoteActivity.class);
                i.putExtra("id",-1);
                startActivity(i);
            }
        });

    }

}