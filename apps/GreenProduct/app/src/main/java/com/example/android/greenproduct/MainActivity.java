package com.example.android.greenproduct;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);


        final ArrayList<GreenProduct> words= new ArrayList<GreenProduct>();

        words.add(new GreenProduct("Elan Apparels Pvt. Ltd, Bandra", "132/-",R.drawable.ic_launcher_1,"Shakti Mill Compound, Dr.E Moses Rd, Mahalaxmi, Mumbai - 400011, Next Toshakti Mills ","9766418100"));
        words.add(new GreenProduct("Handmade Paper Sales Centre, Mahalaxmi", "132/-",R.drawable.ic_launcher_1,"Shakti Mill Compound, Dr. E Moses Rd, Mahalaxmi, Mumbai - 400011, Next Toshakti Mills ","9766418100"));
        words.add(new GreenProduct("Vibgyor Handmade Paper Industry", "234",R.drawable.ic_launcher_1,"Amn, Ambernath South, Thane - 421501, Opp Ambernath Rly Station","251-2601974"));
        words.add(new GreenProduct("Green Feather Ecobags, Bhayandar", "245",R.drawable.ic_launcher_1,"Shop No 6, Shivmati Building, Bhayandar West, Thane - 401101","9321019734"));
        words.add(new GreenProduct("Papier Mache, Malad", "867",R.drawable.ic_launcher_1,"1, Suleman Niwas, Malad East, Mumbai - 400097, Behind Parekh Apartment, Raheja Township","9819320009/28764224"));
        words.add(new GreenProduct("Recokraft, Aarey Milk Colony", "867",R.drawable.ic_launcher_1,";","9820524535"));
        words.add(new GreenProduct("Paptex Laminates Pvt. Ltd, Vikhroli", "897",R.drawable.ic_launcher_1,"C/4,Suyog Indl Estate, Lbs Marg, Vikhroli West, Mumbai - 400083, Opp Vitrum Glass Factory","022-25786054/9821145542"));
        words.add(new GreenProduct("• Asmita", "879",R.drawable.ic_launcher_1,"B/22, Kalyani Kendra, Borivali East, Mumbai - 400066, Ashokvan, Hanuman Tekdi, Near 301 Last Bus Stop","022-28973400"));





        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        final GreenProductAdapter adapter = new GreenProductAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                            GreenProduct green = words.get(position);


                Intent detailintent = new Intent(MainActivity.this,Details.class);
                 detailintent.putExtra("name", green.getmProductname());
                detailintent.putExtra("price", green.getmProductprice());
                detailintent.putExtra("image", green.getImageResourceID());
                detailintent.putExtra("add", green.getmAdd());
                detailintent.putExtra("contact", green.getMcontact());


                startActivity(detailintent);

            }


        });

    }

    }

