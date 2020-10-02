package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class viewFeed extends AppCompatActivity {

    TextView name,comment,number;
    DatabaseReference ref;
    ImageButton btn,btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_feed);

        final String s1=getIntent().getStringExtra("key");


        name = findViewById(R.id.name);
        comment = findViewById(R.id.comment);
        number = findViewById(R.id.num);


        String nm = getIntent().getStringExtra("nm");
        String em = getIntent().getStringExtra("cm");
        String ph = getIntent().getStringExtra("rt");

        name.setText(nm);
        comment.setText(em);
        number.setText(ph);

        btn = findViewById(R.id.ib3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Category.class);
                startActivity(i);
            }
        });
    }
}