package com.example.android.greenproduct;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.greenproduct.*;

import java.util.ArrayList;

import static android.content.Intent.ACTION_VIEW;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by uday on 1/5/2017.
 */

public class GreenProductAdapter extends ArrayAdapter {

    public GreenProductAdapter(Activity context, ArrayList<GreenProduct> words) {

        super(context, 0, words);
    }

    View listItemView;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        final GreenProduct currentWord = (GreenProduct) getItem(position);

        TextView ProductName = (TextView) listItemView.findViewById(R.id.name_text_view);
        ProductName.setText(currentWord.getmProductname());
;

        TextView ProductPrice = (TextView) listItemView.findViewById(R.id.price_text_view);
        ProductPrice.setText(currentWord.getmProductprice());

        TextView Address = (TextView) listItemView.findViewById(R.id.add_text_view);
        Address.setText(currentWord.getmAdd());

        TextView Contact = (TextView) listItemView.findViewById(R.id.contact_text_view);
        Contact.setText(currentWord.getMcontact());


        ImageView ImageResource = (ImageView) listItemView.findViewById(R.id.image_view);
        ImageResource.setImageResource(currentWord.getImageResourceID());



        return listItemView;

    }
}