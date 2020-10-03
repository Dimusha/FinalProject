package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class legs extends AppCompatActivity {

    Button btt1,btt2,btt3,btt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        btt1 = findViewById(R.id.butt9);
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),Addotherdata3.class);
                startActivity(i1);

                Toast.makeText(getApplicationContext(),"Enter Your Daily Plan",Toast.LENGTH_SHORT ).show();

            }
        });

        btt2 = findViewById(R.id.buttl1);
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(),chairpose.class);
                startActivity(i2);
            }
        });
        btt3 = findViewById(R.id.buttonl2);
        btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),warrior.class);
                startActivity(i3);
            }
        });
        btt4 = findViewById(R.id.buttonl3);
        btt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(),cresent.class);
                startActivity(i4);
            }
        });

    }
}