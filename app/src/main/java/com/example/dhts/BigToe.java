package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BigToe extends AppCompatActivity {


    Button btt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_toe);

    btt1=findViewById(R.id.butt9);
    btt1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent  i1 =new  Intent(getApplicationContext(),Addotherdata.class);
            startActivity(i1);

            Toast.makeText(getApplicationContext(),"Enter Your Daily Plan",Toast.LENGTH_SHORT ).show();
        }
    });


    }
}