package com.example.android.info;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uday on 1/6/2017.
 */
public class InformAdapter extends ArrayAdapter {


     private View listItemView;


    public InformAdapter(Activity context, ArrayList<Inform> information) {
        super(context, 0, information);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }

        final Inform currentWord = (Inform) getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(currentWord.getMname());

        return listItemView;
    }
}