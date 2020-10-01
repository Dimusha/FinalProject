package com.example.withoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class armspart extends AppCompatActivity {

    Button wallpushi,tricepdipi,plankshoultap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armspart);

        wallpushi =  findViewById(R.id.wallpush);
        tricepdipi =  findViewById(R.id.tricepdip);
        plankshoultap = findViewById(R.id.shoultap);

        wallpushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),wallpush.class);
                startActivity(i);
            }
        });
        tricepdipi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),tricepdips.class);
                startActivity(i);
            }
        });
        plankshoultap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),shouldertaps.class);
                startActivity(i);
            }
        });
    }
}