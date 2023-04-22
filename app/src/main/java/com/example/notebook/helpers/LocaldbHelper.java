package com.example.notebook.helpers;

//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.notebook.models.Note;

import java.util.ArrayList;

public class LocaldbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "NoteDatabase.db";
    private static final int DATABASE_VERSION = 1;



    public LocaldbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your database tables here
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " +
                "myTable (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, catagory TEXT,description TEXT)";
        db.execSQL(createTableQuery);
    }
    public Note getNote(int id){
        Note note=new Note();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {"title","catagory","description","id"}; // Specify the columns you want to fetch


        Cursor cursor = db.query(
                "myTable",
                projection,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor != null && cursor.moveToFirst()) {


            do {


                if(id!=cursor.getInt(cursor.getColumnIndexOrThrow("id"))){
                    continue;
                }
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String catagory = cursor.getString(cursor.getColumnIndexOrThrow("catagory"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                //int id=cursor.getInt(cursor.getColumnIndexOrThrow("id"));

                // Do something with the retrieved data
                // e.g., update UI, store in data structure, etc.
                note=new Note(title,catagory,description,id);
                return note;
            } while (cursor.moveToNext());
        }
        cursor.close();
        return  note;
    }


    public  void saveNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",note.getTitle());
        contentValues.put("catagory",note.getCatagory());
        contentValues.put("description",note.getDescription());
        db.insert("myTable", null, contentValues);
        db.close();
    }
    public ArrayList<Note> getNotes(){
        ArrayList<Note> myArrayList = new ArrayList<Note>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {"title","catagory","description","id"}; // Specify the columns you want to fetch


        Cursor cursor = db.query(
                "myTable",
                projection,
                null,
                null,
                null,
                null,
                null
        );
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String catagory = cursor.getString(cursor.getColumnIndexOrThrow("catagory"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                int id=cursor.getInt(cursor.getColumnIndexOrThrow("id"));

                // Do something with the retrieved data
                // e.g., update UI, store in data structure, etc.
                Note n1=new Note(title,catagory,description,id);
                myArrayList.add(n1);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return  myArrayList;
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrade logic here
        // You can modify the database schema or perform other upgrade tasks
    }
}

