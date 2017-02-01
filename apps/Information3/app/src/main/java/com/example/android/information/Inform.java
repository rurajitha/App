package com.example.android.information;

import static android.R.attr.name;

/**
 * Created by uday on 12/15/2016.
 */

public class Inform {
    private String mname;
    private String murl;



    public Inform(String name , String url) {
       mname=name;
        murl= url;

    }


    public String getMname()
    {
        return mname;
            }

    public String getMurl()
    {
        return murl;
    }
    
}
