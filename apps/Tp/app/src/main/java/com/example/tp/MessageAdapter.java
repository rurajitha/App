package com.example.tp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.location.Location;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;
import java.text.DecimalFormat;

/**
 * Created by uday on 12/3/2016.
 */

public class MessageAdapter extends ArrayAdapter {

    View listItemView;
    private static final String LOCATION_SEPARATOR = " of ";


    public MessageAdapter(Activity context, ArrayList<Message> messages) {

        super(context, 0, messages);
    }


    @NonNull
    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Message currentmessage = (Message) getItem(position);

        TextView Page = (TextView) listItemView.findViewById(R.id.page);
        Page.setText(currentmessage.getMnextPage());

        TextView Result = (TextView) listItemView.findViewById(R.id.result);
        Result.setText(currentmessage.getMresultsize());


        return listItemView;
    }
    }

