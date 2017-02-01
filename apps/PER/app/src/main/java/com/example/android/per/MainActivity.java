package com.example.android.per;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.content.Intent.ACTION_SEND;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView mondini =(TextView) findViewById(R.id.mondini);
        TextView hub =(TextView) findViewById(R.id.hub);
        TextView it =(TextView) findViewById(R.id.it);
        TextView mech =(TextView) findViewById(R.id.mech);
        TextView  board =(TextView) findViewById(R.id.board_room);
        TextView marine =(TextView) findViewById(R.id.marine);
        TextView extc =(TextView) findViewById(R.id.extc);
        TextView comps =(TextView) findViewById(R.id.comps);

        mondini.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {

                String subject = "permission";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,"Mail will go here .\n" +
                        "\n" +
                        "\n lol ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }});

        hub.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                String subject = "permission";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,"Mail will go here .\n" +
                        "\n" +
                        "\n lol ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }});

        it.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                String subject = "permission";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,"Mail will go here .\n" +
                        "\n" +
                        "\n lol ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }});

        mech.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                String subject = "permission";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,"Mail will go here .\n" +
                        "\n" +
                        "\n lol ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }});

        marine.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND,Uri.fromParts("mailto","abc@gmail.com", null));
                intent.putExtra(Intent.EXTRA_TEXT,"Mail will go here .\n" +
                        "\n" +
                        "\n lol ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }});
        board.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                String subject = "permission";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,"Mail will go here .\n" +
                        "\n"+
                        "\n lol ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }});

        extc.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                String subject = "permission";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,"Mail will go here .\n\n\n lol ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }});

        comps.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                String subject = "permission";
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                // intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                // intent.putExtra(Intent.EXTRA_EMAIL, "abcde");
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT,"This is of no use..GO WRITE LETTERS ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }});
    }
}
