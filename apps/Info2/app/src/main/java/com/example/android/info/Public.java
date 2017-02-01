package com.example.android.info;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by uday on 1/6/2017.
 */

public class Public extends AppCompatActivity {


    private  InformAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);


        ArrayList<Inform> information3 = new ArrayList<Inform>();

        information3.add(new Inform("introductory", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M01.pdf"));
        information3.add(new Inform("Prastavanasanstha, the details of the organization, functions and duties ", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M02.pdf"));
        information3.add(new Inform("Officers and employees of the rights and duties", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M03.pdf"));
        information3.add(new Inform("The Rules, Regulations, Instructions, Manuals and Records", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M04.pdf"));
        information3.add(new Inform("Details of the existing system of policy planning or to advise or represent their people's representative in relation to its implementation", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M05.pdf"));
        information3.add(new Inform("Dharanadhina or control document types Statement", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M06.pdf"));
        information3.add(new Inform("Boards and components, councils, committees and other groups of its Part", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M07.pdf"));
        information3.add(new Inform("Information Officers names, designations and other particulars ", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M08.pdf"));
        information3.add(new Inform("Procedure Followed in Decision Making Process", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform(" Directory of officers and employees ", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform(" System of compensation available in the Regulations, each of the officers and employees of the monthly remuneration received", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform("The Budget allocated to each of the Agents (the details of all plans, proposed expenditures and reports on the distribution)", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform("Manner of Execution of Subsidy Program", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform("Concessions, get the details of the non-Permits", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform("Norms for the organization measures its Functions", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform(" The information available in electronic format", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform(" Details of facilities available to citizens for obtaining information", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));
        information3.add(new Inform(" Other Useful Information", "http://portal.mcgm.gov.in/irj/go/km/docs/documents/MCGM%20Department%20List/Public%20Health%20Department/RTI%20Manuals/PubHealthDept_RTI_M09.pdf"));




        adapter = new InformAdapter(Public.this, information3);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
         ListView listView = (ListView) findViewById(R.id.list_item);

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
