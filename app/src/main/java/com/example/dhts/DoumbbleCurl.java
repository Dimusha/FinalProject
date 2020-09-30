package com.example.dhts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoumbbleCurl extends AppCompatActivity {

    Button btn;
    TextView eypment, cheststep1, cheststep2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doumbble_curl);

        btn = findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddDoumbleCurl.class);
                startActivity(i);
            }
        });

        eypment = findViewById(R.id.eq1);
        cheststep1 = findViewById(R.id.st1);
        cheststep2 = findViewById(R.id.st2);

        String eq1 = getIntent().getStringExtra("f0");
        String st1 = getIntent().getStringExtra("f1");
        String st2 = getIntent().getStringExtra("f2");

        eypment.setText(eq1);
        cheststep1.setText(st1);
        cheststep2.setText(st2);

    }
}