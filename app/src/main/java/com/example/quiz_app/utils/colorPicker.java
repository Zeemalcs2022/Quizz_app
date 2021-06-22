package com.example.quiz_app.utils;

import com.example.quiz_app.models.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class colorPicker {
    int currentColorIndex = 0;
    List<String> colors = Arrays.asList("black","gray","yellow","lightgray","darkgray");

    private static colorPicker color_Picker = null;
    public static colorPicker getInstance(){
        if(color_Picker == null)
        {
            color_Picker = new colorPicker();
        }
        return color_Picker;
    }
    public String getcolor()
    {
        currentColorIndex = (currentColorIndex + 1) % colors.size();
        return colors.get(currentColorIndex);
    }

}
