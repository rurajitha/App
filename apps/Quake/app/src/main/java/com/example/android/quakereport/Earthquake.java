package com.example.android.quakereport;

import android.location.Location;

import static com.example.android.quakereport.R.id.magnitude;

/**
 * Created by uday on 12/3/2016.
 */

public class Earthquake {

    private double mmag;
    private  String mLocation;
    private long mtime;
    private String murl;



    public Earthquake(double mag,String Location ,long time,String url){
         mmag=  mag;
        mLocation = Location;
        mtime = time;
        murl =url;
    }

    public double getMmag()
    { return mmag;}

    public long getMtime(){
        return mtime;
    }

    public String getmLocation(){
        return mLocation;
    }

    public String getUrl(){
        return murl;
    }





}
