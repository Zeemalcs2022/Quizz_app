package com.example.quiz_app.models;

import java.util.HashMap;
import java.util.Map;

public class Quiz {
    String id ="";
    String title = "";
    Map<String,Questions> questions = new HashMap<>();

    public Quiz(){}

    public Quiz(String id, String title) {
        this.id = id;
        this.title = title;
    }

    //getter setter...
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id=id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                '}';
    }
}
