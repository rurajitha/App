package com.example.android.greenproduct;

/**
 * Created by uday on 1/5/2017.
 */

public class GreenProduct {

    private String mProductname;
    private String mProductprice;
    private int mImageResourceID=-1;
     private String mAdd;
    private String mcontact;

    public GreenProduct(String Productname,String Productprice,int ImageResourceID, String Add, String contact) {
        mAdd = Add;
        mcontact= contact;
        mImageResourceID = ImageResourceID;
        mProductname = Productname;
        mProductprice = Productprice;
            }


    public String getmProductname() {
        return mProductname;
    }

    public String getmProductprice() {
        return mProductprice;
    }

    public int getImageResourceID(){return mImageResourceID;}

    public String getMcontact(){return mcontact;}

    public String getmAdd(){return mAdd;}


}
