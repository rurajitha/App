package com.example.android.event;

import android.location.Address;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by uday on 1/7/2017.
 */

public class Details  extends AppCompatActivity {


    private String mName;
    private String mDate;
    private String mLocation;
    private int mImageResourceID =  R.drawable.ic_add_black_24dp;
    private String mcontact = "192093";


    public Details( ){


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        mName = (String) getIntent().getStringExtra("name");
        mDate= (String) getIntent().getStringExtra("date");
        mLocation = (String) getIntent().getStringExtra("add");



        TextView EventName = (TextView) findViewById(R.id.textView4);
        EventName.setText(mName);


        TextView Date = (TextView) findViewById(R.id.textView6);
        Date.setText(mDate);


        TextView Address = (TextView) findViewById(R.id.textView8);
        Address.setText(mLocation);

        TextView Contact = (TextView) findViewById(R.id.textView10);
        Contact.setText(mcontact);


        ImageView ImageResource = (ImageView) findViewById(R.id.imageView);
        ImageResource.setImageResource(mImageResourceID);





    }


}

