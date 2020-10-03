package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewEX extends AppCompatActivity {

    Button button2,button4,button5,button6,button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_e_x);


        button2 = findViewById(R.id.btp);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(),BigToe.class);
                startActivity(i2);

            }
        });

        button4=findViewById(R.id.cb);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i4 = new Intent(getApplicationContext(),cobrapose.class);
                startActivity(i4);
            }
        });

        button6=findViewById(R.id.kpp);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i6 = new Intent(getApplicationContext(),Kingpegonpose.class);
                startActivity(i6);
            }
        });
        button7 = findViewById(R.id.butt90);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i7 = new Intent(getApplicationContext(),Addotherdata.class);
                startActivity(i7);

                Toast.makeText(getApplicationContext(),"Enter Your Daily Plan",Toast.LENGTH_SHORT ).show();

            }
        });

    }
}