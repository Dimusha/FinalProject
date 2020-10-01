package com.example.withoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class planktodown extends AppCompatActivity {

    Button e1;
    TextView vstep,vdesc;
    ImageView addedimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planktodown);

        addedimage=findViewById(R.id.addedplank);

        e1 = findViewById(R.id.addingb);
        vstep =findViewById(R.id.stepname);
        vdesc =findViewById(R.id.desci);


        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3  = new Intent(getApplicationContext(),addingplankto.class);
                startActivity(i3);

            }
        });





        String vestep = getIntent().getStringExtra("f0");
        String vedesc = getIntent().getStringExtra("f1");



        vstep.setText(vestep);
        vdesc.setText(vedesc);


    }
}