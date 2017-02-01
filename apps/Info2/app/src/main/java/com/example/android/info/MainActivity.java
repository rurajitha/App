package com.example.android.info;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.attr.y;
import static android.content.Intent.ACTION_VIEW;
import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView school =(TextView) findViewById(R.id.school);
        TextView water =(TextView) findViewById(R.id.water);
        TextView stormwater =(TextView) findViewById(R.id.storm_water);
        TextView publichealth =(TextView) findViewById(R.id.public_health);
        TextView  msdp=(TextView) findViewById(R.id.msdp);
        TextView ac =(TextView) findViewById(R.id.ac_planning);
        TextView mobile =(TextView) findViewById(R.id.mobile_towers);
        TextView complaints =(TextView) findViewById(R.id.complaints);

        school.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent schoolIntent = new Intent(MainActivity.this, School.class);
                startActivity(schoolIntent);
                            }});


         water.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent waterIntent = new Intent(MainActivity.this, Water.class);
                startActivity(waterIntent);
            }});
        stormwater.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent stormIntent = new Intent(MainActivity.this, Storm.class);
                startActivity(stormIntent);
            }});
        publichealth.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent publicIntent = new Intent(MainActivity.this, Public.class);
                startActivity(publicIntent);
            }});
        msdp.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent msdpIntent = new Intent(MainActivity.this, Msdp.class);
                startActivity(msdpIntent);
            }});
        mobile.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://portal.mcgm.gov.in/irj/go/km/docs/documents/ListOfMobileTower/ListOfMobileTower.pdf");
                Intent mobileIntent = new Intent(ACTION_VIEW,uri);
                startActivity(mobileIntent);
            }});

        complaints.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.mcgm.gov.in/irj/portal/anonymous?NavigationTarget=navurl://1541a2917b15d1b4a1a0713c12eb56ff&guest_user=english");


                Intent complaintIntent = new Intent(ACTION_VIEW,uri);
                startActivity(complaintIntent);
            }});
        ac.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent acIntent = new Intent(MainActivity.this, Ac.class);
                startActivity(acIntent);
            }});



    }
}
