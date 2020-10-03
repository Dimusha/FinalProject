package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class abbspart extends AppCompatActivity {

    Button flutteri,bicyclecrunch,crunchesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abbspart);

        flutteri = findViewById(R.id.flutter);
        bicyclecrunch = findViewById(R.id.bicycle);
        crunchesi = findViewById(R.id.crunches);

        flutteri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),flutterkicks.class);
                startActivity(i);
            }
        });
        bicyclecrunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),bicycleexercise.class);
                startActivity(i);
            }
        });
        crunchesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),crunches.class);
                startActivity(i);
            }
        });
    }
}