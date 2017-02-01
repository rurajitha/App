package com.example.android.info;

/**
 * Created by uday on 1/6/2017.
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


