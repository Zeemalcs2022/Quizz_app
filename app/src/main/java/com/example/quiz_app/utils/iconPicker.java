package com.example.quiz_app.utils;

import com.example.quiz_app.R;

import java.util.Arrays;
import java.util.List;

public class iconPicker {
    int currentIconIndex = 0;
    List<Integer> icons = Arrays.asList(R.drawable.ic_icon1,R.drawable.ic_icon2,R.drawable.ic_icon3,R.drawable.ic_icon4,R.drawable.ic_icon5,R.drawable.ic_icon6,R.drawable.ic_icon7,R.drawable.ic_icon8);

    private static iconPicker icon_Picker = null;
    public static iconPicker getInstance(){
        if(icon_Picker == null)
        {
            icon_Picker = new iconPicker();
        }
        return icon_Picker;
    }
    public int getIcon()
    {
        currentIconIndex = (currentIconIndex + 1) % icons.size();
        return icons.get(currentIconIndex);
    }

}
