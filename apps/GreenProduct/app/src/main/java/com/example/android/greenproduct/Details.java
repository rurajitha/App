package com.example.android.greenproduct;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.android.greenproduct.R.layout.details;

/**
 * Created by uday on 1/6/2017.
 */

public class Details extends AppCompatActivity{

    private String mProductname;
    private String mProductprice;
    private int mImageResourceID=-1;
    private String mAdd;
    private String mcontact;

    public Details( ){


    }

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details);

         mAdd = (String) getIntent().getStringExtra("add");
        mcontact= (String) getIntent().getStringExtra("contact");
    mImageResourceID = (int) getIntent().getIntExtra("image",0);
    mProductname = (String) getIntent().getStringExtra("name");
    mProductprice = (String) getIntent().getStringExtra("price");


    TextView ProductName = (TextView) findViewById(R.id.textView4);
    ProductName.setText(mProductname);


    TextView ProductPrice = (TextView) findViewById(R.id.textView6);
    ProductPrice.setText(mProductprice);

    TextView Address = (TextView) findViewById(R.id.textView8);
    Address.setText(mAdd);

    TextView Contact = (TextView) findViewById(R.id.textView10);
    Contact.setText(mcontact);


    ImageView ImageResource = (ImageView) findViewById(R.id.imageView);
    ImageResource.setImageResource(mImageResourceID);





}


}
