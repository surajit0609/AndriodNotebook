package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notebook.helpers.LocaldbHelper;
import com.example.notebook.models.Note;

public class AddNoteActivity extends AppCompatActivity {
    EditText et_title,et_catagory,et_description;
    Button save_button;
    int id;
    void save(){
        //Toast.makeText(AddNoteActivity.this,title.getText(),Toast.LENGTH_LONG).show();
        String title,description,catagory;
        title=et_title.getText().toString();
        description=et_description.getText().toString();
        catagory=et_catagory.getText().toString();



        Note n1=new Note(title,description,catagory,id);
        LocaldbHelper localdbHelper=new LocaldbHelper(AddNoteActivity.this);
        localdbHelper.saveNote(n1);
        return;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        et_title= findViewById(R.id.title);
        et_catagory=findViewById(R.id.category);
        et_description=findViewById(R.id.description);
        save_button=findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save();
            }
        });

        Intent i=getIntent();

         String sid=i.getStringExtra("id");
        Integer Iid=Integer.parseInt(sid);
        id=Iid.intValue();
        if(id!=-1){
            LocaldbHelper localdbHelper=new LocaldbHelper(AddNoteActivity.this);
            Note n1=localdbHelper.getNote(id);
            et_title.setText(n1.getTitle());
            et_catagory.setText(n1.getCatagory());
            et_description.setText(n1.getDescription());
        }

    }
}