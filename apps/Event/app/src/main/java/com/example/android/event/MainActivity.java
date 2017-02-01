package com.example.android.event;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity {

    EventAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  /*      LinearLayout mAddButton =(LinearLayout) findViewById(R.id.mail);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String subject = "request to add the event";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
               // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
               // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
            });
*/
        final ArrayList<Events> events =new ArrayList<Events>();

        events.add(new Events("Tree Plantation","1/12/12"," MIDC Building, Vardaan Sankul, Number 10,, Wagle Estate Road, Thane West, Padwal Nagar, Thane, Maharashtra 400604"));
        events.add(new Events("Swach Bharat","1/12/12","Collector Office, Court Naka, Thane (West), Maharashtra 400601"));
        events.add(new Events("Teach India","1/12/12","Unit No. G1, Dosti Pinnacle, Plot No E7, Road Number 22, Wagle Industrial Estate, Thane West, Thane, Maharashtra 400604"));
        events.add(new Events("Workshop","1/12/12","MIDC Building, Vardaan Sankul, Number 10,, Wagle Estate Road, Thane West, Padwal Nagar, Thane, Maharashtra 400604"));
        events.add(new Events("Tree Plantation","1/12/12","MIDC Building, Vardaan Sankul, Number 10,, Wagle Estate Road, Thane West, Padwal Nagar, Thane, Maharashtra 400604"));
        events.add(new Events("Swach Bharat","1/12/12","Unit No. G1, Dosti Pinnacle, Plot No E7, Road Number 22, Wagle Industrial Estate, Thane West, Thane, Maharashtra 400604"));
        events.add(new Events("Teach India","1/12/12","MIDC Building, Vardaan Sankul, Number 10,, Wagle Estate Road, Thane West, Padwal Nagar, Thane, Maharashtra 400604"));
        events.add(new Events("Workshop","1/12/12","MIDC Building, Vardaan Sankul, Number 10,, Wagle Estate Road, Thane West, Padwal Nagar, Thane, Maharashtra 400604r"));
        events.add(new Events("Tree Plantation","1/12/12","Unit No. G1, Dosti Pinnacle, Plot No E7, Road Number 22, Wagle Industrial Estate, Thane West, Thane, Maharashtra 400604"));
        events.add(new Events("Swach Bharat","1/12/12","MIDC Building, Vardaan Sankul, Number 10,, Wagle Estate Road, Thane West, Padwal Nagar, Thane, Maharashtra 400604"));
        events.add(new Events("Teach India","1/12/12","Unit No. G1, Dosti Pinnacle, Plot No E7, Road Number 22, Wagle Industrial Estate, Thane West, Thane, Maharashtra 400604"));
        events.add(new Events("Workshop","1/12/12","MIDC Building, Vardaan Sankul, Number 10,, Wagle Estate Road, Thane West, Padwal Nagar, Thane, Maharashtra 400604"));



        adapter = new EventAdapter(this,events);
        final ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Events event = events.get(position);


                Intent detailintent = new Intent(MainActivity.this,Details.class);
                detailintent.putExtra("name", event.getmName());
                detailintent.putExtra("date", event.getmDate());
                detailintent.putExtra("add", event.getmLocation());


                startActivity(detailintent);

            }


        });

    }
}

