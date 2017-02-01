package com.example.android.information;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uday on 12/16/2016.
 */

public class InformAdapter extends ArrayAdapter {


    View listItemView;


    public InformAdapter(Activity context, ArrayList<Inform> information) {
        super(context, 0, information);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

       final Inform currentWord = (Inform) getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(currentWord.getMname());

     return listItemView;
    }
}