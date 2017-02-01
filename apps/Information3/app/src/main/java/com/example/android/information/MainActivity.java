package com.example.android.information;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  InformAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Inform> information = new ArrayList<Inform>();

        information.add(new Inform("Ward Wise Departmental Manuals ", "http://portal.mcgm.gov.in/irj/portal/anonymous?NavigationTarget=navurl://b431c704f4844bdfb30603c5171a211b"));
        information.add(new Inform("Work order / Purchase order ", "http://portal.mcgm.gov.in/irj/portal/anonymous/qlpurorddetails"));
        information.add(new Inform("Garden department ", "http://portal.mcgm.gov.in/irj/portal/anonymous/qlgarden?guest_user=english"));
        information.add(new Inform("Schools (education department)", "http://portal.mcgm.gov.in/irj/portal/anonymous/qledutnoff?guest_user=english"));
        information.add(new Inform("Water supply (hydraulics engineering) department", "http://portal.mcgm.gov.in/irj/portal/anonymous/qlhedept"));
        information.add(new Inform("Storm water drains department", "http://portal.mcgm.gov.in/irj/portal/anonymous/qlswd"));
        information.add(new Inform("Public health department ", "http://portal.mcgm.gov.in/irj/portal/anonymous/qlpublichealthdept"));
        information.add(new Inform("MSDP ", "http://portal.mcgm.gov.in/irj/portal/anonymous/qlmsdp"));
        information.add(new Inform("AC Planning ", "http://portal.mcgm.gov.in/irj/portal/anonymous/qlBudget1415?guest_user=english"));
        information.add(new Inform(" Mobile towers ", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/ListOfMobileTower/ListOfMobileTower.pdf"));
        information.add(new Inform(" Complaints", "http://www.mcgm.gov.in/irj/portal/anonymous?NavigationTarget=navurl://1541a2917b15d1b4a1a0713c12eb56ff"));




        adapter = new InformAdapter(this, information);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        final ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);


        // to open a website with more information about the selected complaint.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Inform current =(Inform) adapter.getItem(position);


                Uri uri = Uri.parse(current.getMurl());



                Intent websiteIntent = new Intent(Intent.ACTION_VIEW,uri);


                startActivity(websiteIntent);}





            });



    }
}
