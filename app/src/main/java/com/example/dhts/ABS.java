package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ABS extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_b_s);

        bt1 = findViewById(R.id.buttn49);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getApplicationContext(),singlearm.class);
                startActivity(i1);
            }
        });
        bt2=findViewById(R.id.buttn53);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getApplicationContext(),forarms.class);
                startActivity(i2);


            }
        });
        bt3=findViewById(R.id.buttn50);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(getApplicationContext(),upwarddog.class);
                startActivity(i3);
            }
        });

        bt5=findViewById(R.id.butto91);
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i5 = new Intent(getApplicationContext(),Addotherdata2.class);
                startActivity(i5);

                Toast.makeText(getApplicationContext(),"Enter Your Daily Plan",Toast.LENGTH_SHORT ).show();



            }
        });



    }
}