package com.example.android.event;

import java.util.Date;

/**
 * Created by uday on 12/23/2016.
 */

public class Events {

    private String mName;
    private String mDate;
    private String mLocation;

    public  Events(String Name, String Date ,String Location) {
        mName = Name;
        mDate = Date;
        mLocation = Location;

    }


    public String getmName(){
        return mName;
    }


    public String getmDate(){
        return mDate;
    }


    public String getmLocation(){
        return mLocation;
    }




}
