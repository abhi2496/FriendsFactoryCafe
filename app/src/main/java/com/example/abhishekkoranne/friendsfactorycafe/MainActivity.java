package com.example.abhishekkoranne.friendsfactorycafe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    ImageButton call, website, directions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.call);
        website = findViewById(R.id.website);
        directions = findViewById(R.id.directions);

        final String phoneNumber = getApplicationContext().getString(R.string.phoneNumber);
        final String websiteURL = getApplicationContext().getString(R.string.websiteURL);
        final String locationURL = getApplicationContext().getString(R.string.locationURL);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(Intent.ACTION_VIEW);
                ii.setData(Uri.parse(websiteURL));
                startActivity(ii);
            }
        });

        directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri locUri = Uri.parse(locationURL);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, locUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
