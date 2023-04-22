package com.example.notebook.models;

public class Note {
    String title,description,catagory;
    int id;

    public Note() {
    }

    public Note(String title, String description, String catagory,int id) {
        this.title = title;
        this.description = description;
        this.catagory = catagory;
        this.id=id;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }

    public String getCatagory() {
        return catagory;
    }
    public  int getId(){return  id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
    public  void setId(int id){this.id=id;}
}
