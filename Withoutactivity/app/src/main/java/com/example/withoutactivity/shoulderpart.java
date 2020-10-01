package com.example.withoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shoulderpart extends AppCompatActivity {
    Button pdown,crabwalk,pikepushu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulderpart);
        pdown = findViewById(R.id.planktdown);
        crabwalk = findViewById(R.id.crab);
        pikepushu = findViewById(R.id.pike);

        pdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),planktodown.class);
                startActivity(i);
            }
        });

        crabwalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),CrabWalk.class);
                startActivity(i);
            }
        });

        pikepushu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),pikepushup.class);
                startActivity(i);

            }
        });
    }
}