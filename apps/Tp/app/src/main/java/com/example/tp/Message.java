package com.example.tp;

/**
 * Created by uday on 12/28/2016.
 */

public class Message {
    private String mnextPage;
    private int mresultsize;

    public Message(String nextPage, int resultsize){
        mnextPage= nextPage;
        mresultsize = resultsize;

    }

    public String getMnextPage(){
        return mnextPage;
    }

    public int getMresultsize()
    {return mresultsize;}




}
