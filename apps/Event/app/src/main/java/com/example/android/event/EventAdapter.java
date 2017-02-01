package com.example.android.event;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.R.attr.name;

/**
 * Created by uday on 12/23/2016.
 */

public class EventAdapter extends ArrayAdapter {

    View listItemView;


    public EventAdapter(Activity context, ArrayList<Events> events) {
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final Events currentWord = (Events) getItem(position);

     /*   TextView Location = (TextView) listItemView.findViewById(R.id.location);
        Location.setText(currentWord.getmLocation());
   */

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(currentWord.getmName());

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(currentWord.getmDate());

        Date dateObject = new Date(currentWord.getmDate());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);



        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }


}
