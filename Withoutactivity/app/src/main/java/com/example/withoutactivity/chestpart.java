package com.example.withoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chestpart extends AppCompatActivity {

    Button regpushi,inclinepushi,declinepushi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chestpart);

        regpushi = findViewById(R.id.regpush);
        inclinepushi = findViewById(R.id.inclinepush);
        declinepushi = findViewById(R.id.declinepush);


        regpushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),regularpushup.class);
                startActivity(i);
            }
        });

        inclinepushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),InclinePushup.class);
                startActivity(i);
            }
        });

        declinepushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),declinepushup.class);
                startActivity(i);
            }
        });

    }
}